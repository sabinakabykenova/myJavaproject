import java.util.ArrayList;
import java.util.Scanner;

class Esep61{
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("p=");
        int p= scanner.nextInt();
        System.out.print("a=");
        int a= scanner.nextInt();
        System.out.print("b=");
        int b= scanner.nextInt();

        System.out.println("");

        int a2= (int) (4*Math.pow(a,3));
        int b2= (int) (27*Math.pow(b,2));
        int y= fact_power(a2,b2,p);
        if(y==0){
            System.out.println("y==0");
        } else System.out.println("y="+y);

        for (int i = 0; i < 10; i++) {
            System.out.println("Введите х:");
            int x1= scanner.nextInt();
            System.out.println("Введите y:");
            int y2 = scanner.nextInt();
            int c=fact_power((int) Math.pow(y2,2),1,p);
            if(x1>0){
                int i1= (int) (Math.pow(x1,3)+4*x1+7);
                int y1=fact_power(i1,1,p);
                if(c==y1){ System.out.println("y1="+y2+" ("+x1+","+y2+")");}
                else System.out.println("Не принадлежит");
            }
            if(x1==0) break;
        }



    }
}