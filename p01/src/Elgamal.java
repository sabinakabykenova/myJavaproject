import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;
import java.util.Scanner;

public class Elgamal
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        BigInteger p, b, c, secretKey;
        Random sc = new SecureRandom();
        secretKey = new BigInteger("1234");
        //
        // public key calculation
        //
        System.out.println("secretKey = " + secretKey);
        p = BigInteger.probablePrime(64, sc);
        b = new BigInteger("3");
        c = b.modPow(secretKey, p);
        System.out.println("p = " + p);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        //
        // Encryption
        //
        System.out.print("Введите сообщение (большое число) -->");
        String s = scan.next();
        BigInteger X = new BigInteger(s);
        BigInteger r = new BigInteger(64, sc);
        BigInteger EC = X.multiply(c.modPow(r, p)).mod(p);
        BigInteger brmodp = b.modPow(r, p);
        System.out.println("Сообщение = " + X);
        System.out.println("целое число r такое, что 1 < r < (p − 1) ---> r = " + r);
        //System.out.println("EC = " + EC);
        System.out.println("Первая часть зашифрованного сообщения b^r mod p = " + brmodp);
        //
        // Decryption
        //
        BigInteger crmodp = brmodp.modPow(secretKey, p);
        BigInteger d = crmodp.modInverse(p);
        BigInteger ad = d.multiply(EC).mod(p);
        System.out.println("Вторая часть зашифрованного сообщения c^r mod p = " + crmodp);
        //System.out.println("d = " + d);
        System.out.println("Дешифрованное сообщение: " + ad);

    }
}