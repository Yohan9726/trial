import java.util.*;

class trial {
    public static void main(String[] args) {
        System.out.println("first file");
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            a.add(i);
        }
        a.forEach(item -> {
            System.out.print(item + " ");
        });
    }
}