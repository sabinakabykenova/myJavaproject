import java.util.Scanner;
public class Gam {
    public static void main(String[] args) {
        System.out.print("Сөз1: ");
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        System.out.print("Сөз2: ");
        String str2 = scanner.next();

        int c = 0,d=0;
        int c1 = 0,d1=0;
        int y = 0,y2=0;
        String new_str = "";
        String new_str2 = "";

        for (int i = 0; i < str.length(); i++) {

            c =  (str.charAt(i) );
            d =  (str2.charAt(i) );
            c1 = (c - 1040) % 32 + 1; // 1040 - это код буквы А, 32 - это кол-во букв
            d1 = (d - 1040) % 32 + 1; // 1040 - это код буквы А, 32 - это кол-во букв
            y=c1+d1%33;
            y2=y+1039;
            new_str +=  y+" "; // получаем букву по коду
            new_str2 += (char) y2;
        }
        System.out.println(new_str);
        System.out.println(new_str2);
    }
}