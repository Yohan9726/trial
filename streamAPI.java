import java.util.stream.*;
import java.util.*;

//Stream just generates a stream of elements from a given source
//It does not store any data itself
//Operations performed on stream does not alter source

class streamAPI {
    public static void main(String[] args) throws java.lang.Exception {
        List<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(20);
        l.add(30);

        // Printing all the items in list using stream

        l.stream()
        .filter(integer -> integer > 10 && integer < 30)
        .forEach(System.out::println);

        // Generating a new list using stream after some conditions

        List<Integer> m = l.stream().filter(num -> num > 10) //Choosing elements greater than 10
        .map(num -> num) //Choosing every property from every element
        .collect(Collectors.toList()); //Converting to list

        System.out.println("New list");
        m.forEach(System.out::println);
    }
}