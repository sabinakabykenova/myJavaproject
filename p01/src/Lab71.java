
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab71 {
    public static int gcd(int c,int p) {
        int d=1;
        while(c*d%(p-1)!=1){
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
        Scanner scanner =new Scanner(System.in);
        System.out.print("p=");
        int p= scanner.nextInt();
        System.out.print("alfa=");
        int alfa= scanner.nextInt();
        System.out.print("beta=");
        int beta= scanner.nextInt();
        System.out.print("gamma=");
        int gamma= scanner.nextInt();
        System.out.print("Ca=");
        int Ca= scanner.nextInt();
        System.out.print("Cb=");
        int Cb= scanner.nextInt();
        int Da=gcd(Ca,p),Db=gcd(Cb,p);
        System.out.print("Алиса перемешивает карты по правилу (1,2,3)->( , , )\n1=");
        int one= scanner.nextInt();
        System.out.print("2=");
        int two = scanner.nextInt();
        System.out.print("3=");
        int three = scanner.nextInt();
        int [] nom=new int[]{one,two,three};
        int [] kart=new int[]{1,2,3};
        for (int i = 0; i < kart.length; i++) {
            switch (nom[i]){
                case 1: kart[i]=alfa;
                    break;
                case 2: kart[i]=beta;
                    break;
                case 3: kart[i]=gamma;
                    break;
            }
//            System.out.print(kart[i]+" ");
        }


        int [] u=new int[3];

        for (int i = 0; i < u.length; i++) {
            u[i]=fact_power(kart[i],Ca,p);
            System.out.print(u[i]+" ");
        }

        System.out.print("\nВыбор Боба (1,2,3) ");
        int vibBoba= scanner.nextInt();
        vibBoba=vibBoba-1;


        int size=u.length;
        int j;
        for ( j = 0; j < size; j++)
            if (j == vibBoba)
                break;
        for (int k = j; k < size- 1; k++)
            u[k] = u[k + 1];
        size--;

        for (int i = 0; i < size; i++) {
            System.out.print(u[i]+" ");
        }
        System.out.print("\nИспользовать перестановку(1-Да/2-Нет)? ");
        int str= scanner.nextInt();
        int temp;
        int uB[]=new int[2];
        if (str==1){
            for (int i = 0; i < size/2; i++) {
                temp = u[size-i-1];
                u[size-i-1] = u[i];
                u[i] = temp;
            }
            for (int i=0; i<size; i++){
                uB[i]=fact_power(u[i],Cb,p);
                System.out.print("u"+(i+1)+"="+uB[i]+" ");
            }


        } else{
            for (int i=0; i<size; i++){
                uB[i]=fact_power(u[i],Cb,p);
                System.out.print("u"+(i+1)+"="+uB[i]+" ");
            }
        }
        int w ,z;
        System.out.println("\nDa="+Da+"\nDb="+Db);
        System.out.print("Выбор Алисы (1,2)- ");
        int vibA= scanner.nextInt();
        if (vibBoba==1)
            w = fact_power(uB[0], Da, p);
        else
            w = fact_power(uB[1], Da, p);
        z=fact_power(w,Db,p);
        System.out.println("w="+w+"\nz="+z);
        if(z==alfa){
            System.out.println("Bob- alfa");
        }
        else if(z==beta){
            System.out.println("Bob- beta");
        }
        else {
            System.out.println("Bob- gamma");
        }
    }
}
