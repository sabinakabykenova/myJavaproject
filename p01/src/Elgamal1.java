import java.util.ArrayList;

import static java.lang.Math.pow;

public class Elgamal1 {
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
        int p = 23, g = 5;
        int x = 10, k = 15, m = 5;
        //Y ashyq kilt
        int y=fact_power(g,x,p);
        System.out.println("Y = A^X mod P="+y);
        // a men b tabu shifrlau
        int a= fact_power(g,k,p);
        System.out.println("a="+a);
        int b1= fact_power((m-a*x),1,p-1);
        if (b1<0){
            b1=(p-1)+b1;
        }
        System.out.println("b1="+b1);

        //keri
        int b2 = 0;
        for (int i = 2; i < p-1; i++) {
            int y2 = k * i;
            if (fact_power(y2, 1, p-1) == 1) {
                b2 = i;
                System.out.println("b2=" + b2);
            }
        }

        int b=fact_power(b1*b2,1,p-1);

        System.out.println("(a,b)= ("+a+","+b+")");
        //tekseru
        int t1=fact_power(a,b,p);
        int t2= fact_power(y,a,p);
        int t3=fact_power(t1*t2,1,p);
        System.out.println("y^a*a^b(mod p)="+t3);
        int t4= fact_power(g,m,p);
        System.out.println("k^H(m) (mod p)="+t4);
    }
}
