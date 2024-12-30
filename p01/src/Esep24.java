
public class Esep24 {
    public static int gcd(int n, int m) {

        if (m > n) return gcd(m,n);
        if (m==0) return n;
        return gcd(m,n%m);
    }

    public static boolean isprime(int m, int n)
    {
        return (gcd(n,m)==1);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(isprime(25,12));
        System.out.println(isprime(25,15));
    }
}