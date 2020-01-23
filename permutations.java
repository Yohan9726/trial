import java.util.*;

class permute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String s = sc.next();
        System.out.println("The permutations are : ");
        permDriver(s,"");
        sc.close();
    }

    public static void permDriver(String s,String s2) {
        if(s.length() == 0) {
            System.out.println(s2);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            String r = s.substring(0,i) + s.substring(i + 1);

            permDriver(r, s2 + ch);
        }
    }
}