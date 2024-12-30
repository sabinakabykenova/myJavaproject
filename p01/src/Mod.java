import java.util.Scanner;

public class Mod {

    public static void main(String[] args)   {
        int sum=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n>0){
            sum=sum/n%10;
            n=n/10;
        }
        sum=Math.abs(sum);
        System.out.println(sum);

    }

}

