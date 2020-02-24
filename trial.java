class trial2 {
    private int x = 10;
    
    trial2() {

    }

    trial2(int x) {
        this.x = x;
    }

    private int getX() {
        return this.x;
    }
}

class trial {
    public static void main(String[] args) {
        System.out.println("New branch created");
        trial2 t = new trial2(20);
        // System.out.println(t.x);
        // System.out.println(t.getX());

        int x = 0;

        int y = 10;

        do {

        y--;

        ++x;

        } while (x < 5);
        System.out.print(x + "," + y);
    }
}