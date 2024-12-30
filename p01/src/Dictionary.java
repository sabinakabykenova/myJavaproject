import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Dictionary {
    public static void main(String[] args) {
        String password = "secretPassword123";
        String hashedPassword = "hashStringOrPassword";

        // Предполагается что у нас есть список слов
        String[] dictionary = {"password", "123456", "qwerty", "letmein", "secretPassword123"};

        for (String word : dictionary) {
            if (validatePassword(word, hashedPassword)) {
                System.out.println("Пароль найден в словаре: " + word);
                break;
            }
        }
    }

    public static boolean validatePassword(String password, String hashedPassword) {
        // Генерация ключа из пароля
        KeySpec spec = new PBEKeySpec(password.toCharArray(), "salt".getBytes(), 65536, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] testHash = factory.generateSecret(spec).getEncoded();
            // Сравнение полученного хэша с хэшем из словаря
            String testHashBase64 = Base64.getEncoder().encodeToString(testHash);
            if (testHashBase64.equals(hashedPassword)) {
                return true; // Пароль найден
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }
}