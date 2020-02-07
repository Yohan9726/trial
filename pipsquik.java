import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class pipsquik
{
public static void main (String[] args) throws java.lang.Exception
{
// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = br.readLine();
        int tests=0;
        try{tests = Integer.parseInt(br.readLine());}catch(Exception e){}
        int N,H,Y1,Y2,L;

        int i = 0;
        int count = 0;
        int[] answers = new int[tests];

        while(tests > 0) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            H = Integer.parseInt(data[1]);
            Y1 = Integer.parseInt(data[2]);
            Y2 = Integer.parseInt(data[3]);
            L = Integer.parseInt(data[4]);

            while(N-- > 0) {
                String[] testCases = br.readLine().split(" ");
                int t = Integer.parseInt(testCases[0]);
                int X = Integer.parseInt(testCases[1]);

                int result = barrier(t, X, H, Y1, Y2, L);

                if(result == -1) {
                    break;
                }
                else if(result == 0) {
                    count++;
                    L--;
                }
                else {
                    count++;
                }
            }

            answers[i++] = count;
            count = 0;
            tests--;
        }
        for(int ans : answers) {
            System.out.println(ans);
        }
    }
   
    public static int barrier(int t,int X, int H, int Y1, int Y2, int L) {
        if(t == 1) {
            if(H - Y1 <= X) {
                return 1;
            }
            else {
                L--;
                if(L <= 0) {
                    return -1;
                }
                else {
                    return 0; //if L is changed
                }
            }
        }
        else {
            if(Y2 >= X) {
                return 1;
            }
            else {
                L--;
                if(L <= 0) {
                    return -1;
                }
                else {
                    return 0; // if L is changed
                }
            }
        }
    }
}