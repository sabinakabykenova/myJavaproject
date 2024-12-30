import java.util.ArrayList;
import java.util.Scanner;

public class Esep62 {
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
    public static int evklid(double a,  double b) {
        double n;
        if (a < b) {
            n = b;
            b = a;
            a = (int) n;
        }
        double[] l1 = {a, 1, 0};
        double[] l2 = {b, 0, 1};
        double[] l3 = new double[3];
        while (l1[0] - l2[0] * (l1[0] / l2[0]) > 0) {
            for (int j = 0; j < 3; j++) l3[j] = l2[j];
            double q = l1[0] / l2[0];
            for (int i = 0; i < 3; i++) {
                l2[i] = (l1[i] - l2[i] * q);
            }
            for (int k = 0; k < 3; k++) l1[k] = l3[k];
        }
        return (int) l2[2];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = 7;
        int a = 2;
        int b = 6;
        System.out.println("E11(2, 6) : Y^2 = X^3 + 2X + 6 (mod 7).");
        //k = (3*x1^2+a)/ 2*y1
        System.out.println("Есептің шартында берілген нуктелердің х1 енгізіңіз:");
        int x1= scanner.nextInt();
        System.out.println("Есептің шартында берілген нуктелердің y1 енгізіңіз:");
        int y1= scanner.nextInt();
        System.out.println("Есептің шартында берілген нуктелердің х2 енгізіңіз:");
        int x2= scanner.nextInt();
        System.out.println("Есептің шартында берілген нуктелердің y2 енгізіңіз:");
        int y2= scanner.nextInt();
        if((x2-x1)==0){
            System.out.println("Санды 0-ге бөлуге болмайды!");
        } else {
            int k = (y2 - y1) / (x2 - x1);
            System.out.println("k=" + k);
            //
            int x31 = (int) (Math.pow(k, 2) - x1 - x2);
            int x3 = 0;
            if (x31 > 0) {
                x3 = fact_power(x31, 1, p);

            } else {
                x3 = x31 + p;
                if (x3 < 0) {
                    x3 = x31 + 2 * p;
                }
            }
            //System.out.println("x3="+x31);
            System.out.println("x3=" + x3);
            int y31 = (int) (k * (x1 - x3) - y1);
            int y3 = 0;
            if (y31 > 0) {
                y3 = fact_power(y31, 1, p);
            } else {
                y3 = y31 + p;
            }
            // System.out.println("y3="+y31);

            System.out.println("y3=" + y3);
            System.out.println("Жауабы: (" + x3 + "," + y3 + ")");

        }
    }
}