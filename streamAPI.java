import java.util.stream.*;
import java.util.*;

//Stream just generates a stream of elements from a given source
//It does not store any data itself
//Operations performed on stream does not alter source

//Most used functions are :
/*
.stream() : To convert to stream
.filter() : To filter elements based on a predicate
.map() : To generate a new stream of elements with the chosen properties
.collect() : To create a new list or other data structures from the stream
.limit(long limitNumber) : To limit number of data upto a certain point
.skip(long skipUptoThisNumber) : To skip the first elements upto the specified value
.max(Comparator c) : Finds the maximum value based on comparator
.min(Comparator c) : Find the minimum value based on comparator 
.reduce(initialize,(var1,var2)) : To get an accumulated value in var1 based on the logic given
.count() : Counts number of elements in stream
*/

class streamAPI {
    public static void main(String[] args) throws java.lang.Exception {
        List<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(20);
        l.add(30);

        // Printing items in list using stream

        l.stream()
        .filter(integer -> integer > 10 && integer < 30)
        .forEach(System.out::println);

        // Generating a new list using stream after some conditions

        List<Integer> m = l.stream().filter(num -> num > 10) //Choosing elements greater than 10
        .map(num -> num) //Choosing every property from every element
        .collect(Collectors.toList()); //Converting to list

        System.out.println("New list");
        m.forEach(System.out::println);


        //reduce()

        int sumOfNumbers = l.stream()
        .map(num -> num) //Taking the entire numbers and not any properties. Can be commented out in this case.
        .reduce(0,(sumAccumulate,numbers) -> sumAccumulate + numbers); //The first value is the initialization of sumAccumulate
        //The sum is accumulated in the first variable
        //The second variable is the reference to each element of the stream

        System.out.println("Sum : " + sumOfNumbers);

        //max()

        int maxNumber = l.stream()
        .map(num -> num)
        .max((n1,n2) -> // Can also be written as : max((n1,n2) -> n1 > n2 ? 1 : -1)
        {
            if(n1 > n2) //n1 and n2 are two variables that refer to 2 elements of the stream
            return 1; //1 denotes the first variable. n1 in this case
            else 
            return -1; //-1 denotes the second variable. n2 in this case
        }).get(); //get() method is mandatory to get the maximum element
        //If n1 is greater than n2 then choose n1 (denoted by the integer 1) else choose n2

        System.out.println("Max number : " + maxNumber);
    }
}