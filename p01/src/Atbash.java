

import java.util.Scanner;

public class Atbash {
    public static class src
    {
        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Shifrlau kerek sozdi engiz: ");
            String message = keyboard.nextLine();
            System.out.println("\nShifr: " + decrypt(message).toUpperCase());
        }
        public static String decrypt( String message )
        {
            StringBuilder decoded = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    int newChar = ('Z' - c) + 'A';
                    decoded.append((char) newChar);
                } else {
                    decoded.append(c);
                }
            }
            return decoded.toString();
        }
    }
}
