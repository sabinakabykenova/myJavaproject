import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Rsa1 {

    public static int fact_power( int g,int x, int p){
        ArrayList<Integer> dec=new ArrayList<Integer>();
        while(x>0) {
            dec.add(x%2);
            x/=2;
        }
        int y=1;
        for (int i = 0; i < dec.size(); i++) {

            y*=((int) pow(g,dec.get(i)))%p;
            g=g*g%p; }
        return y%p;
    }

    public static void main(String[] args) {
        int N=33,d=3,C=13;
        System.out.print("N=33,d=3,C=13 berilgen ");


        Scanner in = new Scanner(System.in);
        System.out.print("p= ");
        int p = in.nextInt();
        System.out.print("q= ");
        int q = in.nextInt();
        int f=(p-1)*(q-1);

        //jabyq kilt
        System.out.println("\nf= (P – 1) * (Q – 1)="+(p-1)+"*"+(q-1)+"="+f+
                "\n(d * e) mod f = 1   1 < e < f");
        int e=0;
        for (int i = 2; i < f; i++) {
            int y=d*i;
            if(fact_power(y,1,f)==1){
                e=i;
                System.out.println("e="+e);}
        }
        System.out.println("Ashyq kilt N="+N+" d="+d +
                "\n Jabyq kilt="+e);

        //deshifrlau
        int m2=fact_power(C,e,N);
        System.out.println("\ndeshifrlau" +
                "\n m' = C^e mod N="+C+"^"+e+" mod "+N+" = "+m2);
    }

}
