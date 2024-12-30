import java.util.ArrayList;
import java.util.Scanner;

public class Esep65 {
    public static String tek(int num){
        int temp;
        boolean isPrime=true;


        // zhai san
        for (int i=2; i<=num/2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }

        if(isPrime)
            return " ";
        else {
            return (num + "");
        }


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
        System.out.println(tek(p));
        System.out.print("x=");
        int x= scanner.nextInt();
        System.out.print("g=");
        int g= scanner.nextInt();
        System.out.print("h(m)=");
        int h= scanner.nextInt();
        System.out.print("k=");
        int k= scanner.nextInt();
        int y=fact_power(g,x,p);
        System.out.println("y="+y);
        int r=fact_power(g,k,p);
        System.out.println("r="+r);
        int u=fact_power(h-x*r,1,p-1);
        while (u<0){
            u=u+(p-1);
        }

        System.out.println("u="+u);
        int ksh=modI(k,p-1);
        System.out.println("ksh="+ksh);
        int s=fact_power(ksh*u,1,p-1);
        //2
        int a1=fact_power(fact_power(y,r,p)*fact_power(r,s,p),1,p);
        int a2=fact_power(g,h,p);
        System.out.println(a1+"="+a2);

    }
}