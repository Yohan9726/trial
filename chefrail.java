import java.io.*;
import java.time.*;

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class chefrail {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int tests = Integer.parseInt(br.readLine());
            int[] answers = new int[tests];
            int j = 0;

            Instant start = Instant.now();

            while(tests-- > 0) {
                String XY = br.readLine();
                int[] x = new int[Integer.parseInt(XY.split(" ")[0])]; //Storing x-coordinates
                int[] y = new int[Integer.parseInt(XY.split(" ")[1])]; //Storing y-coordinates

                String xc = br.readLine();
                String yc = br.readLine();

                for(int i = 0; i < x.length; i++) {
                    x[i] = Integer.parseInt(xc.split(" ")[i]);
                }

                for(int i = 0; i < y.length; i++) {
                    y[i] = Integer.parseInt(yc.split(" ")[i]);
                }

                answers[j++] = count(x,y);
            }

            for(int ans : answers) {
                System.out.println(ans);
            }

            Instant finish = Instant.now();

            System.out.println("Time taken : " + Duration.between(start, finish).toMillis());
        }

        catch(Exception e) {

        }
    }

    public static int count(int[] x, int[] y) {
        int i,j,k,count = 0;

        for(i = 0; i < x.length - 1; i++) {
            for(j = i + 1; j < x.length; j++) {
                for(k = 0; k < y.length; k++) {
                    point p1 = new point(x[i],0);
                    point p2 = new point(x[j],0);
                    point p3 = new point(0,y[k]);

                    if(right(p1,p2,p3) == true) {
                        count++;
                    }
                }
            }
        }

        for(i = 0; i < y.length - 1; i++) {
            for(j = i + 1; j < y.length; j++) {
                for(k = 0; k < x.length; k++) {
                    point p1 = new point(0,y[i]);
                    point p2 = new point(0,y[j]);
                    point p3 = new point(x[k],0);

                    if(right(p1,p2,p3) == true) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static boolean right(point p1,point p2, point p3) {
        double d1 = distance(p1,p2); d1 = d1 * d1;
        double d2 = distance(p1,p3); d2 = d2 * d2;
        double d3 = distance(p2,p3); d3 = d3 * d3;

        int id1 = (int)(Math.round(d1));
        int id2 = (int)(Math.round(d2));
        int id3 = (int)(Math.round(d3));

        //Pythagoras Theorem

        if((id1 + id2 == id3) || (id2 + id3 == id1) || (id1 + id3 == id2)) {
            return true;
        }
        return false;
    }

    public static double distance(point x, point y) {
        //Euclidean distance

        double d1 = Math.pow((x.x - y.x),2);
        double d2 = Math.pow((x.y - y.y),2);

        return (Math.sqrt(d1 + d2));
    }
}