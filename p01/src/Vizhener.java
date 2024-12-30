
import java.util.Scanner;
public class Vizhener {
    private static String key;
    public static void setKey(String key) {
        Vizhener.key = key;
    }
    public static String getKey() {
        return key;
    }
    public static String encrypt(String text, String key){
        String code="";
        for (int i = 0; i < text.length(); i++) {
            int buf=(((text.toUpperCase().charAt(i)-65)+(key.toUpperCase().charAt(i%key.length())-65))%26+66);
            code+=buf==91? (char)(buf-26): (char)buf;
        }
        return code;
    }
    public static String decrypt(String code, String key){
        String text="";
        for (int i = 0; i < code.length(); i++) {
            text+=(char)(((code.toUpperCase().charAt(i)-65)-(key.toUpperCase().charAt(i%key.length())-65)+26)%26+64);
        }
        return text;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("текст: ");
        String text=sc.nextLine();
// String text="cryptography";
        System.out.print("ключ: ");
        setKey(sc.nextLine());
// setKey("vigenere");
        String key=getKey();
        String code=encrypt(text, key);
        String decode=decrypt(code,key);
        //encode the text
        System.out.println("код: "+ code);
        //decode the code
        System.out.println("дешифр: "+decode);
    }
}
