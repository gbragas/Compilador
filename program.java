import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        Scanner _scTrx = new Scanner(System.in);
        String palavra;
        int a;
        int b;
        int fazoele;
        int c;
        int d;
        palavra = _scTrx.nextLine();
        System.out.println(palavra);
        a = _scTrx.nextInt();
        b = _scTrx.nextInt();
        System.out.println("somando 2 no a");
        a += 2;
        System.out.println(a);
        System.out.println("");
        System.out.println("");
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
        a = 4;
        b = 10;
        System.out.println("Teste do While Printando a ate b");
        System.out.println("a vale:");
        System.out.println(a);
        System.out.println("b vale:");
        System.out.println(b);
        System.out.println("--- Inicio do teste While ---");
        while (a<=b) {
            System.out.println(a);
            a += 1;
        }
        System.out.println("--- FEIN ---");
        System.out.println(" ------------------ ");
        System.out.println("Teste do Do-While Printando 4 a 10");
        System.out.println(a);
        System.out.println(b);
        do {
            a += 1;
            System.out.println(a);
        } while (a<10); 
    }
}
