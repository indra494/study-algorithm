package codility;

import java.util.Arrays;

public class Test06 {
/*
A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
*/


    public static void main(String args[]) {
        int A[] = {3,1,2,4,3};

        int totSum = 0;
        for(int i=0; i<A.length; i++) {
            totSum += A[i];
        }

        int sum = 0;
        int min = (int)1e9;

        for(int i=0; i<A.length-1; i++) {
            sum += A[i];
            int numer = totSum - (sum*2);
            numer = numer < 0 ? numer * -1 : numer;

            if(min > numer) {
                min = numer;
            }

            if(min <= 1) break;
            //System.out.println(min);
        }
        System.out.println(min);

    }

}
