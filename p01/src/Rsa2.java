import java.util.ArrayList;
import java.util.Scanner;

public class Rsa2 {

    public static int fact_power( int g,int x, int p){
        ArrayList<Integer> dec=new ArrayList<Integer>();
        while(x>0) {
            dec.add(x%2);
            x/=2;
        }
        int y=1;
        for (int i = 0; i < dec.size(); i++) {
            y*=((int)Math.pow(g,dec.get(i)))%p;
            g=g*g%p;
        }
        return y%p;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("p=");
        int p = in.nextInt();
        System.out.print("Q=");
        int Q = in.nextInt();
        System.out.print("d=");
        int d = in.nextInt();
        System.out.print("m=");
        int m = in.nextInt();
        int N=p*Q;

        int c= fact_power(m,d,N);

        System.out.println("c="+c);

    }
}