import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Esep214 {
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
        System.out.print("p=");
        int p= scanner.nextInt();

        System.out.print("g=");
        int g= scanner.nextInt();
        System.out.print("Xa=");
        int Xa= scanner.nextInt();

        System.out.print("Xb=");
        int Xb= scanner.nextInt();

        int Ya=fact_power(g,Xa,p);
        int Yb=fact_power(g,Xb,p);
        System.out.println("Ya="+Ya);
        System.out.println("Yb="+Yb);
        int Zab=fact_power(Yb,Xa,p);
        int Zba=fact_power(Ya,Xb,p);

        System.out.println("Zba="+Zba);
        System.out.println("Zba="+Zab);


    }

}