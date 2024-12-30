
import java.util.*;

public class Esep23 {
    public static void factorize(int n,int k)
    {
        if (k>n) return;
        if (n%k==0)
        {
            System.out.println(k);
            while(n%k==0)
            {
                n=n/k;
            }
        }
        factorize(n,k+1);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        System.out.print("n=");
        n=inp.nextInt();
        factorize(n,2);
    }
}