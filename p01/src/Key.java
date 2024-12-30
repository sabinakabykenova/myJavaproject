import Sbox.SBox;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class Key {

    private byte[] inputKey = new byte[32];
    private ArrayList<Integer> keysM = new ArrayList<>();
    private ArrayList<Integer> keysR = new ArrayList<>();

    private int[] S1 = SBox.S1;
    private int[] S2 = SBox.S2;
    private int[] S3 = SBox.S3;
    private int[] S4 = SBox.S4;

    public Key(byte[] key) throws Exception {

        if (key.length < 16 || key.length > 32)
            throw new Exception("Key size is incorrect");

        for (int i = 0; i < key.length; i++) {
            this.inputKey[i] = key[i];
        }

        keyResize();
    }

    private void keyResize() {

        int[] tmp = new int[8];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = ByteBuffer.wrap(inputKey, 4 * i, 4).getInt();
        }

        int Cm = 0x5a827999;
        int Mm = 0x6ed9eba1;
        int Cr = 19;
        int Mr = 17;
        int[][] Tm = new int[24][8];
        int[][] Tr = new int[24][8];

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 8; j++) {
                Tm[i][j] = Cm;
                Cm = (Cm + Mm) & 0xFF;
                Tr[i][j] = Cr;
                Cr = (Cr + Mr)& 0xFF;
            }
        }

        for (int i = 0; i < 12; i++) {
            getKeys(W(tmp, Tm[2*i], Tr[2*i]));
            getKeys(W(tmp, Tm[2*i + 1], Tr[2*i + 1]));
        }

        System.out.println(Integer.toHexString(keysR.get(0)) +  Integer.toHexString(keysM.get(0)));

    }

    private void getKeys(int[] array){
        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0){
                int I = array[i];
                keysR.add((I << 5 | I >>> (32 - 5)));
            } else{
                keysM.add(array[i]);
            }
        }
    }

    private int[] W(int[] array, int[] Tm, int[] Tr) {

        int[] result = new int[8];

        for (int i = 6, counter = 0; i >= 0; i--, counter++) {
            switch (i % 3) {
                case 1:
                    result[i] = array[i] ^ f1(array[i + 1], Tm[counter], Tr[counter]);
                    break;
                case 2:
                    result[i] = array[i] ^ f2(array[i + 1], Tm[counter], Tr[counter]);
                    break;
                default:
                    result[i] = array[i] ^ f3(array[i + 1], Tm[counter], Tr[counter]);
                    break;
            }
        }
        result[7] = array[7] ^ f2(result[0], Tm[7], Tr[7]);
        return result;
    }

    private final int f1(int I, int m, int r) {
        I = m + I;
        I = I << r | I >>> (32 - r);
        return (((S1[(I >>> 24) ]) ^ S2[(I >>> 16) ]) - S3[(I >>> 8) ]) + S4[I ];
    }

    private final int f2(int I, int m, int r) {
        I = m ^ I;
        I = I << r | I >>> (32 - r);
        return (((S1[(I >>> 24) & 0xFF]) - S2[(I >>> 16) & 0xFF]) + S3[(I >>> 8) & 0xFF]) ^ S4[I & 0xFF];
    }

    private final int f3(int I, int m, int r) {
        I = m - I;
        I = I << r | I >>> (32 - r);
        return (((S1[(I >>> 24) & 0xFF]) + S2[(I >>> 16) & 0xFF]) ^ S3[(I >>> 8) & 0xFF]) - S4[I & 0xFF];
    }

}