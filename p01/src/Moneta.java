
import java.util.Scanner;
public class Moneta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1=1;
        System.out.print("P= ");
        int P = in.nextInt();
        for ( int i=2; i < P; i++) {
            if ( P%i == 0 ) {
                System.out.print("Введите простое число!" +
                        "\n Введите значение P. P= ");
                P = in.nextInt();
            }
            else if(P==a1){
                System.out.print("Введите простое число!" +
                        "\n Введите значение P. P= ");
                P = in.nextInt();
            }
        }
        System.out.print("G= ");
        int G = in.nextInt();

        int x = a1 + (int) (Math.random() * (P-1));
        int y= (int) Math.pow(G,x) % P;

        System.out.println("Алиса құпия кездейсоқ алған х саны арқылы y есептеп, сізге жіберді.\ny= "+y);


        int k = a1 + (int) (Math.random() * (100));
        int b = (int) (Math.random() * 2);
        String b2=Integer.toBinaryString(b);

        int r= (int) (Math.pow(y,b) * Math.pow(G,k))% P;
        System.out.println("Боб Алисаға r=y^b*g^k (mod p) формуласы бойынша есептеген r мәнін жіберді. \nr="+r);


        int c =  (int) (Math.random() * 2);
        System.out.println(" Алиса Бобқа кездейсоқ таңдаған с битін жіберді. \nc=" +c);

        System.out.println("Боб Алисаға b, k мәндерін жіберді.\nb= "+b+ "\nk= "+k);


        int d= b^c ;
        System.out.println("Алиса алынған b, k мәндерін r=y^b*g^k (mod p) орындарына койып тексереді," +
                "\nегер бәрі дұрыс болса d=bXORc= "+b+"XOR"+c+"="+d);
    }
}