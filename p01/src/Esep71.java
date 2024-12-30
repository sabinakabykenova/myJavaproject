
import java.util.Scanner;

public class Esep71 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("m=");
        String m= scanner.next();
        System.out.print("k=");
        String k= scanner.next();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m.length(); i++)
            sb.append((m.charAt(i) ^ k.charAt(i)));

        String e = sb.toString();
        System.out.println("e="+e);

    }
}