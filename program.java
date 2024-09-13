import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        Scanner _scTrx = new Scanner(System.in);
        int a;
        int b;
        a = _scTrx.nextInt();
        b = _scTrx.nextInt();
        a = 2;
        b = 3;
        a = b;
        System.out.println("oi");
        if (a + 5 < b - 6) {
            System.out.println(a);
            a = 4;
            a = 4;
        }
        else {
                        System.out.println(b);
            a = 4;
            a = 4;
        }
        System.out.println(a);
        a = 4;
        System.out.println(b);
        a = 4;
        while (a < b) {
            System.out.println(a);
            a = 4;
        }
        do {
            a = 4;
            System.out.println(b);
            a = 4;
        } while (a==b); 
    }
}
