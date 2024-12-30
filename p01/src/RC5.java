import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class RC5 {

    public static byte[] encryptText(String text, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "RC5");
        Cipher cipher = Cipher.getInstance("RC5");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedText = cipher.doFinal(text.getBytes());
        return encryptedText;
    }

    public static String decryptText(byte[] encryptedText, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "RC5");
        Cipher cipher = Cipher.getInstance("RC5");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedText = cipher.doFinal(encryptedText);
        return new String(decryptedText);
    }

    public static void main(String[] args) {
        try {
            String text = "Hello, this is a secret message.";
            byte[] key = "secretkey".getBytes();

            // Шифрование текста
            byte[] encryptedText = encryptText(text, key);
            System.out.println("Зашифрованный текст: " + new String(encryptedText));

            // Дешифрование текста
            String decryptedText = decryptText(encryptedText, key);
            System.out.println("Расшифрованный текст: " + decryptedText);
        } catch (Exception e) {
            System.err.println("Ошибка при шифровании/дешифровании текста: " + e.getMessage());
        }
    }
}
