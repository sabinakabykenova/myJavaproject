
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Esep1 {
    public static int ZhaiSangaTekseru(int n){
        int c=0;
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                //return false;
                n=new Random().ints(1, 1, 100).findFirst().getAsInt();
                ZhaiSangaTekseru(n);
            }
        } c=n;
        return c;
    }

   /* public static void tek(int a, int b){\
        int u[]=new int[]{a,1,0};
        int v[]=new int[]{b,0,1};
        int  q=a/b;
        while (u[0]!=0){
            if (v[0]==0 ){
                break;
            }
            q = (u[0])/ (v[0]);
            int T[]=new int[]{(int)(u[0]%v[0]),(int)(u[1]-q*v[1]),(int)(u[2]-q*v[2])};
            u=v;
            v=T;
        }
        for (int i = 0; i < u.length; i++) {
            System.out.print(u[i]+" ");
        }
    }*/

    public static int fact_power( int g,int x, int p){
        ArrayList<Integer> dec=new ArrayList<Integer>();
        while(x>0) {
            dec.add(x%2);
            x/=2;
        }
        int y=1;
        for (int i = 0; i < dec.size(); i++) {

            y*=((int)Math.pow(g,dec.get(i)))%p;
            g=g*g%p; }
        return y%p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("m= ");
        int m = in.nextInt();
       /* int randomInt = new Random().ints(1, 1, 100).findFirst().getAsInt(); // p
        JaiSangaTekseru(randomInt);
        System.out.println("A B-ga P=" + randomInt + " sanyn ashyq kanal arqyly joldady.");
       */
        System.out.print("p= ");
        int randomInt = in.nextInt();
        System.out.print("cA= ");
        int cA = in.nextInt();
        System.out.print("dA= ");
        int dA = in.nextInt();
        System.out.println("Proverka chisel na vzaimno prostye");
        /*tek(cA,dA);
        if ((cA * dA) % (randomInt - 1) != 1) {
            System.out.println("Qaita engiziniz!");
        }*/
        System.out.print("\ncB= ");
        int cB = in.nextInt();
        System.out.print("dB= ");
        int dB = in.nextInt();
        System.out.println("Proverka chisel na vzaimno prostye");
       /* tek(cB,dB);
       /* if ((cB * dB) % (randomInt - 1) != 1) {
            System.out.println("Qaita engiziniz!");
        }*/
        //1 шаг
        int x1=(int) fact_power(m,cA,randomInt);
        System.out.println("x1=(m^cA)%randomInt="+x1);
        //2 shag
        int x2=(int) fact_power(x1,cB,randomInt);
        System.out.println("x2=(x1^cB)%randomInt="+x2);
        //3 shag
        int x3=(int) fact_power(x2,dA, randomInt);
        System.out.println("x3=(x2^dA)%randomInt="+x3);
        //4
        int x4=(int) fact_power(x3,dB, randomInt);
        System.out.println("x4=(x3^dB)%randomInt="+x4);
        if(x4==m){
            System.out.println("m="+x4);
        } else System.out.println("qate");
    }
}
