import java.io.*;
import java.time.Duration;
import java.time.Instant;

class nochange {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        
        Instant start = Instant.now();
        
        String[] answers = new String[tests];
        int x = 0;
        try {
            while(tests-- > 0) {
                String s = br.readLine();
                int N = Integer.parseInt(s.split(" ")[0]);
                int P = Integer.parseInt(s.split(" ")[1]);

                s = br.readLine();
                int[] D = new int[N];
                for(int i = 0; i < D.length; i++) {
                    D[i] = Integer.parseInt(s.split(" ")[i]);
                }

                answers[x++] = checkChange(P, D);
            }

            for(String ans : answers) {
                System.out.println(ans);
            }
        }

        catch(Exception e) {
        }

        Instant finish = Instant.now();

        System.out.println("Time elapsed : " + Duration.between(start, finish).toMillis());
    }

    public static String checkChange(int P, int[] D) {
        int i;
        for(i = 0; i < D.length; i++) {
            if(P % D[i] != 0) {
                return overCharge(P,D);
            }
        }
        return "NO";
    }

    public static String overCharge(int P, int[] D) {
        int[] coins = new int[D.length];
        int i, checked = 0, max = 0, prevMax = -1;
        int sum = 0, count = 0, minSum = -1;

        for(i = 0; i < D.length; i++) { //Finding the index of maximum coin value
            if(D[i] > D[max]) {
                max = i;
            }
        }

        prevMax = max; //Setting prevMax to the index of maximum coin value

        while(checked < D.length) {
            while(sum <= (P + 1)) {
                sum += D[max];
                count++;
            }
            if(minSum == -1) {
                minSum = sum;
            }

            if(sum <= minSum && sum > P && count > 1) {
                minSum = sum;
                sum -= D[max];

                if(sum > P) {
                    minSum = sum;
                }
                
                count--;
            }

            if(sum == P || (sum > P && sum > minSum)) {
                sum -= D[max] * count;
                count = 0;
            }
            coins[max] = count;
            count = 0;
            prevMax = max;

            checked++;

            //Finding next maximum

            max = 0;
            for(i = 0; i < D.length; i++) {
                if((D[i] > D[max]) && (D[i] < D[prevMax])) {
                    max = i;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("YES ");
        for(int x : coins) {
            sb.append(String.valueOf(x));
            sb.append(" ");
        }

        return (new String(sb));
    }
}