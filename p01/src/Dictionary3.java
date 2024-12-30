import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary3 {
    private static final Map<String, String> passwordDatabase = new HashMap<>();

    public static void main(String[] args) {
        passwordDatabase.put("user1", "5f4dcc3b5aa765d61d8327deb882cf99");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите хэшированный пароль: ");
        String hashedPassword = scanner.nextLine();

        if (passwordDatabase.containsKey(username)) {
            String storedHash = passwordDatabase.get(username);
            if (checkPassword(hashedPassword, storedHash)) {
                System.out.println("Успешный вход для пользователя " + username);
            } else {
                System.out.println("Неверный пароль для пользователя " + username);
                System.out.println("Выполняется атака по словарю...");
                performDictionaryAttack(hashedPassword);
            }
        } else {
            System.out.println("Пользователь " + username + " не найден");
        }
    }

    public static boolean checkPassword(String hashedPassword, String storedHash) {
        return hashedPassword.equals(storedHash);
    }

    public static void performDictionaryAttack(String hashedPassword) {
        String[] passwordDictionary = {"password", "123456", "qwerty", "letmein"};

        for (String password : passwordDictionary) {
            if (checkPassword(hashedPassword, hashPassword(password))) {
                System.out.println("Пароль найден в словаре: " + password);
                return;
            }
        }
        System.out.println("Ни один пароль из словаря не соответствует хэшу.");
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}