package codility.lesson9;

public class MaxProfit {

/*
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
 */

    public static void main(String args[]) throws Exception {

        int A[] = {5,4,3,2,1};

        int max = 0;
        int min = A.length <= 0 ? 0 : A[0];

        for(int i=1; i<A.length; i++) {
            if(A[i]- min > max) max = A[i] - min;
            if(A[i] < min) min = A[i];
        }

        System.out.println(max);
    }

}
