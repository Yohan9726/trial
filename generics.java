import java.util.*; //Imported to use the List collection interface

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

        List<B> b = new ArrayList<B>(); //Arraylist of type Class B
        b.add(new B()); //Adding an object of B as arraylist element

        List<C> c = new ArrayList<C>();
        c.add(new C());

        List<A> a = new ArrayList<A>();
        a.add(new A());

        wildCards(b);
        wildCards(c);
        wildCards(a);
    }

    //Generic Method

    public static <E> void genArray(E[] e) {
        for(E element : e) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //wildcards ('?') can be used to accept any class of any type

    public static void wildCards(List<? extends A> l) { // Any class that inherits or extends class A can be passed as argument as well as class A itself
        for(A obj : l) {
            obj.printData();
        }
    }

    /*
    ? : Unbounded wildcard to accept any class
    ? extends A : Upper bounded wildcard to accept children of A or A itself
    ? super A : Lower bounded wildcard to accept A or the classes from which A inherits , i.e., parent of A
    */
}

class A {
    int a = 10;

    void printData() {
        System.out.println("A : " + a);
    }
}

class B extends A {
    void printData() {
        System.out.println("B : " + super.a);
    }
}

class C extends A {
    void printData() {
        System.out.println("C : " + super.a);
    }
}