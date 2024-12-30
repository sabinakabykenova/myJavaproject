import java.util.ArrayList;
import java.util.Scanner;

public class Esep52 {

    public static int fact_power(int g, int x, int p) {
        ArrayList<Integer> dec = new ArrayList<Integer>();
        while (x > 0) {
            dec.add(x % 2);
            x /= 2;
        }
        int y = 1;
        for (int i = 0; i < dec.size(); i++) {
            y *= ((int) Math.pow(g, dec.get(i))) % p;
            g = g * g % p;
        }
        return y % p;
    }

    public static int evklid(int a, int b) {
        long n;
        if (a < b) {
            n = b;
            b = a;
            a = (int) n;
        }
        long[] l1 = {a, 1, 0};
        long[] l2 = {b, 0, 1};
        long[] l3 = new long[3];
        while (l1[0] - l2[0] * (l1[0] / l2[0]) > 0) {
            for (int j = 0; j < 3; j++) l3[j] = l2[j];
            long q = l1[0] / l2[0];
            for (int i = 0; i < 3; i++) {
                l2[i] = (l1[i] - l2[i] * q);
            }
            for (int k = 0; k < 3; k++) l1[k] = l3[k];
        }
        return (int) l2[2];

    }


    public static void main(String[] args){
        int P=17, Q=7, c=77, N=119, d=5;
        Scanner in = new Scanner(System.in);
        System.out.print("n=");
        int n = in.nextInt();
        System.out.print("r=");
        int r = in.nextInt();

        int n1= (int) (n*Math.pow(r,d)%N);
        System.out.println("n: "+n1);
        int s1= fact_power(n1,c,N);
        System.out.println("s: "+s1);
        System.out.println("r^(-1) mod N=" + evklid(r,N));
        int y= evklid(r,N)*s1;
        int s=y%N;
        System.out.println("банкнота= {"+n+","+s+"}");
    }

}