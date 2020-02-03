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
        a.retainAll(b);
        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println(a.subList(0,1));


        //TreeSet

        TreeSet<Integer> tr = new TreeSet<Integer>();

        tr.add(10);
        tr.add(10);
        tr.add(20);

        Iterator<Integer> itr = tr.descendingIterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        //Hashmap

        HashMap<String,Integer> hs = new HashMap<String,Integer>();

        hs.put("abc",10);
        hs.putIfAbsent("abcs",10);

        System.out.println(hs);

        if(hs.containsKey("abc") == true) {
            hs.replace("abc",20);
        }

        System.out.println(hs);
    }
}