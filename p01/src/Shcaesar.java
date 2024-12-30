import java.util.Scanner;

public class Shcaesar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        System.out.print("Ключ(Сан): ");
        int key = scanner.nextInt();
        System.out.print("Слово: ");
        String str = scanner.next();
        String new_str = "";
        String d = "";
        int c = 0;
        int y = 0;

        //System.out.println((int) 'Я'); // здесь узнаем код буквы


        for (int i = 0; i < str.length(); i++) {
            c =  (str.charAt(i) + key);
            y = (c - 1040) % 32 + 1040; // 1040 - это код буквы А, 32 - это кол-во букв
            new_str += (char) y; // получаем букву по коду
        }
        System.out.println(new_str);
    }
}