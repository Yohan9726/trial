//Generic class

class myGen<T> { // T refers to any type
    T obj; // An object of the type passed

    T createObj(T obj) { // An argument of the type T created
        this.obj = obj;
        return this.obj;
    }
}

class generics {
    public static void main(String[] args) throws java.lang.Exception {
        // Passing Integer as type
        myGen<Integer> m = new myGen<Integer>();

        // 2 is an argument of type Integer
        System.out.println(m.createObj(2)); 

        Integer[] intArray = {1,2,3,4}; //For generics we have to use wrapper classes, i.e., Integer instead of int
        Character[] charArray = {'a','b','c'};

        genArray(intArray);
        genArray(charArray);
    }

    //Generic Method

    public static <E> void genArray(E[] e) {
        for(E element : e) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}