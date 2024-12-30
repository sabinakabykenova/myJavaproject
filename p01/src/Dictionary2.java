import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Dictionary2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите хэшированный пароль: ");
        String hashedPassword = scanner.nextLine();

        System.out.print("Введите количество слов в словаре: ");
        int dictionarySize = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        String[] dictionary = new String[dictionarySize];
        System.out.println("Введите слова словаря:");
        for (int i = 0; i < dictionarySize; i++) {
            dictionary[i] = scanner.nextLine();
        }

        checkPassword(hashedPassword, dictionary);
    }

    public static void checkPassword(String hashedPassword, String[] dictionary) {
        for (String word : dictionary) {
            if (validatePassword(word, hashedPassword)) {
                System.out.println("Пароль найден в словаре: " + word);
                return;
            }
        }
        System.out.println("Пароль не найден в словаре.");
    }

    public static boolean validatePassword(String password, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            String hashedPasswordToCheck = Base64.getEncoder().encodeToString(hash);
            return hashedPasswordToCheck.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}