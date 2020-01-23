/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=*/

import java.util.*;

class min_arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.println("Enter the values(Type anything else to finish) : ");
        while(sc.hasNextInt()) {
            a.add(sc.nextInt());
        }
        sc.close();

        int len = a.size();
        int i = 0;
        int f = -1, l = -1;

        while(len > 1) {
            if(a.get(i) > a.get(i + 1)) {
                
                if(f == -1) {
                    f = i;
                }
                l = i + 1;
            }
            i++;
            len--;
        }
        System.out.println(" Output : " + ((l-f)+1));
    }
}