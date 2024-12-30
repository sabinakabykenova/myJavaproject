
import java.util.ArrayList;
import java.util.Scanner;
public class RSA {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
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
        System.out.print("c=");

        int c = in.nextInt();
        System.out.print("m=");

        int m = in.nextInt();
        int N=p*Q;
        int fi=(p-1)*(Q-1);
        System.out.print("ozara zhai sandar d=");
        int d = in.nextInt();

        String a;
        a = gcd(fi, d)==1? "ya":"zhok";
        System.out.print(a + "\n");
        if(gcd(fi,d)==0){
            System.out.print("fi men oz-ara jai emes bolyp shyqty, qaita engiziniz \nd=");
            d = in.nextInt();
        }
        int s= fact_power(m,c,N);
        int w= fact_power(s,d,N);
        System.out.println("s="+s+"   w="+w);

    }
}
