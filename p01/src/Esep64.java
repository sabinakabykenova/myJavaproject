import java.util.ArrayList;
import java.util.Scanner;

public class Esep64 {
    public static int modI(int x , int p){
        int d=1;
        while((d*x)%p!=1){
            d++;
        }
        return d;
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

    public static void main(String[] args) {
//        c = 5103, D = (12507, 2027);
//        m = 10000, k = 523;
//        R = (9767, 11500), P = (25482, 16638);
//        e = 11685.p = 31991
        Scanner scanner =new Scanner(System.in);
        System.out.print("m=");
        int m= scanner.nextInt();
        System.out.print("x=");
        int x= scanner.nextInt();
        System.out.print("p=");
        int p= scanner.nextInt();
        int e=fact_power(m*x,1,p);
        System.out.println("e="+e);
        int s=modI(x,p);
        m=fact_power(s*e,1,p);

        System.out.println("m="+m);



    }
}