import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        Scanner _scTrx = new Scanner(System.in);
        String palavra;
        int a;
        int b;
        int fazoele;
        int c;
        a = _scTrx.nextInt();
        b = _scTrx.nextInt();
        System.out.println("somando 2 no a");
        a += 2;
        System.out.println(a);
        fazoele = 123.34;
        System.out.println(fazoele);
        palavra = "Abacaxi";
        System.out.println("oi");
        System.out.println(palavra);
        if (a == b) {
            System.out.println("a igual b");

        }
        else {
            System.out.println("a eh diferente de  b");

        }
        while (a < b) {
            System.out.println(a);
            a = 4;
        }
        System.out.println(" ------------ ");
        System.out.println("Teste do DoWhile");
        System.out.println(a);
        System.out.println(b);
        do {
            a += 1;
            System.out.println(a);
        } while (a<10); 
    }
}
