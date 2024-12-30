

import java.util.ArrayList;
import java.util.Scanner;

public class RSA42 {

    public static int fact_power( int p,int g){
        ArrayList<Integer> dec=new ArrayList<Integer>();
        while(p>0) {
            dec.add(p%2);
            p/=2;
        }
        int y=1;
        for (int i = 0; i < dec.size(); i++) {
            y*=((int)Math.pow(g,dec.get(i)))%p;
            g=g*g%p;
        }
        return y%p;
    }
    public static void main(String args[]) {
        //(m,s)
        Scanner in = new Scanner(System.in);
        System.out.print("x=");
        int N = in.nextInt();
        System.out.print("k=");
        int d = in.nextInt();
        System.out.print("m=");
        int m = in.nextInt();


        int k = 0;
        int x = 0;
        int w= fact_power(x,k);
        System.out.println("m="+m+"   w="+w);
    }
}