public class thread {
    public static void main(String[] args) throws myexception {
        try{
            if(2>1) {
                throw new myexception();
            }
        }
        catch(myexception m) {
            System.out.println(m);
        }
        finally {
            System.out.println("Finally block");
        }
    }
}

class myexception extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String toString() {
        return "Exception occurred";
    }
}