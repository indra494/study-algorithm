package codility.lesson9;

public class MaxDoubleSliceSum {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int sum = 0;
        int[] B = new int[A.length];

        for(int k=A.length-2; k>0; k--) {
            sum = Math.max(A[k],sum + A[k]);
            result = Math.max(result,sum);
            B[k] = result;
        }

        result = 0;
        sum = 0;
        for(int i=1; i<A.length-1; i++) {
            sum = Math.max(A[i],sum + A[i]);
            result = Math.max(sum + B[i+1],result);
        }

        return result;
    }

    public static void main(String args[]) {

        int A[] = {3, 2, 6, -1, 4, 5, -1, 2};
        //int A[] = {5,5,5};
        //int A[] = { 5, 17, 0, 3 };

        MaxDoubleSliceSum max = new MaxDoubleSliceSum();
        System.out.println(max.solution(A));


    }



}
