class loop {
    public static void main(String[] args) {
        int i;
        int[] a = {1,2,3,4,5,6,7,8,9,10,11};
        for(i = 0; i < 10;i++) {
            System.out.println(i);
            if(a[i] == 4) {
                a[i] = 666;
                i = i - 1;
            }
        }
    }
}