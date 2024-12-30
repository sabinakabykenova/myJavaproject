
import java.util.ArrayList;
import java.util.Scanner;

public class Lab72 {
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
    public static int modI(int x , int p){
        int d=1;
        while((d*x)%p!=1){
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("p=");
        int p= scanner.nextInt();
        System.out.print("Q=");
        int Q= scanner.nextInt();
        System.out.print("c=");
        int c= scanner.nextInt();
        System.out.print("N=");
        int N= scanner.nextInt();
        System.out.print("d=");
        int d= scanner.nextInt();
        System.out.print("n=");
        int n= scanner.nextInt();
        System.out.print("r=");
        int r= scanner.nextInt();
        int nH=(n*fact_power(r,d,N))%N;
        int sH=fact_power(nH,c,N);
        int s=fact_power(n,c,N);
        int rM=modI(r,N);

        System.out.println("Nh="+nH);
        System.out.println("Sh="+sH);
        System.out.println("r^-1="+rM);
        System.out.println("{"+n+","+s+"}");

    }
}