//Practicing java collections and collection framework

import java.util.*;

class collects {
    public static void main(String[] args) {
        System.out.println("Collections!");
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        a.add(10);
        b.add(30);
        a.addAll(b);

        System.out.println(a);

        Iterator<Integer> i = a.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        //a.retainAll(b);
        System.out.println(a.subList(0,1));
    }
}