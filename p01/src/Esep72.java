
import java.util.Scanner;

/*à. P(a) = 0.1, P(b) = 0.7, P(c) = 0.2, ¯e = abaacac,
á. P(a) = 0.9, P(b) = 0.09, P(c) = 0.01, ¯e = cbaccca,
â. P(a) = 0.14, P(b) = 0.06, P(c) = 0.8, ¯e = bbabbcab,
ã. P(a) = 0.7, P(b) = 0.05, P(c) = 0.25, ¯e = cccacbbc,
ä. P(a) = 0.1, P(b) = 0.7, P(c) = 0.2, ¯e = abbbbab.*/
public class Esep72 {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        double Pa=0.9;
        double Pb=0.09;
        double Pc=0.01;
        System.out.println("P(a): "+Pa);
        System.out.println("P(b): "+Pb);
        System.out.println("P(c): "+Pc);
        //a=2, b=1, c=4
        System.out.println(Pa*Pa);
        double P1=  (Math.pow(Pa,4)*Pb*Math.pow(Pc,2));
        System.out.println("cbaccca P1="+P1);
        double P2=  (Math.pow(Pa,4)*Pc*Math.pow(Pb,2));
        System.out.println("cabcccb P2="+P2);
        double P3=  (Math.pow(Pb,4)*Pa*Math.pow(Pc,2));
        System.out.println("bcabbba P3="+P3);
        double  P4=  (Math.pow(Pb,4)*Pc*Math.pow(Pa,2));
        System.out.println("bacbbbc P4="+P4);
        double  P5=  (Math.pow(Pc,4)*Pa*Math.pow(Pb,2));
        System.out.println("abcaaac P5="+P5);
        double  P6= (Math.pow(Pc,4)*Pb*Math.pow(Pa,2));
        System.out.println("acbaaab P6="+P6);

        double  m = (P1+P2+P3+P4+P5+P6)/6;
        double p1=(P1/6)/m;
        double p2=(P2/6)/m;
        double p3=(P3/6)/m;
        double p4=(P4/6)/m;
        double p5=(P5/6)/m;
        double p6=(P6/6)/m;
        System.out.println("jauaby:" +
                "\nP1="+p3);

        System.out.println("P2="+p4);
        System.out.println("P3="+p5);
        System.out.println("P4="+p6);
        System.out.println("P5="+p2);
        System.out.println("P6="+p1);
    }
}