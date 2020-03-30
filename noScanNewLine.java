import java.util.Scanner;

public class noScanNewLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter string");
        String s = sc.next();
        System.out.println("Enter integer");
        int a = sc.nextInt();
        System.out.println("Enter string again");
        String s2 = sc.next();

        System.out.println("String 1 : " + s);
        System.out.println("Integer : " + a);
        System.out.println("String 2 : " + s2);
        sc.close();
    }
}