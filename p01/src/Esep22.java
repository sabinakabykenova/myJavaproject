
import java.util.*;
import java.lang.*;
import java.io.*;

class Esep22
{
    public static void main (String[] args) throws java.lang.Exception
    {
        long n, k = 0, c = 0;
        Scanner S = new Scanner (System.in);
        n = S.nextLong();
        while (n > 1){
            long bit = n & 1;
            n >>= 1;
            k <<= 1;
            k |= bit;
            c += 1;
        }
        while (c != 0) {
            long bit = k & 1;
            k >>= 1;
            if (bit == 0) System.out.print("S");
            else System.out.print("SX");
            c -= 1;
        }
    }
}

