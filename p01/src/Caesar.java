
import java.util.Locale;
import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        String alphabet= "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        Scanner sc=new Scanner(System.in);
        System.out.print("текст: ");
        String text=sc.next();
        for (int i = 0; i <30 ; i++) {
            int key =i;

            String shifr = "";
            for (int j = 0; j < text.length(); j++) {
                int index = alphabet.indexOf(text.charAt(j));
                int size=alphabet.length();
                int enVal = (key + index) % size;
                char Val = alphabet.charAt(enVal);
                shifr = shifr + Val;
            }
            System.out.print(shifr+" ");
        }

    }
}