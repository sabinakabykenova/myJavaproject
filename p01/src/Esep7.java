import java.util.ArrayList;
import java.util.Scanner;

public class Esep7
{
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
        Scanner scanner=new Scanner(System.in);
        System.out.print("a^x mod p\na=");
        int a= scanner.nextInt();
        System.out.print("x=");
        int x= scanner.nextInt();
        System.out.print("p=");
        int p= scanner.nextInt();

        System.out.println(fact_power(a,x,p));
    }
}
