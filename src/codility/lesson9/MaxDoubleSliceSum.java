package codility.lesson9;

public class MaxDoubleSliceSum {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<=3) return 0;

        int result = 0;
        int sum = 0;

        int[] B = new int[A.length];
        A[0] = 0;

        for(int k=A.length-2; k>0; k--) {
            sum = Math.max(A[k],sum + A[k]);
            B[k] = sum;
        }

        result = 0;
        sum = 0;
        for(int i=0; i<A.length-2; i++) {
            sum = Math.max(A[i],sum + A[i]);
            result = Math.max( (sum<0 ? 0 : sum) + (B[i+2]<0 ? 0 : B[i+2]),result);
        }

        return result;
    }

    public int solution2(int[] A) {
        if(A.length == 3) return 0;

        int[] headSum = new int[A.length];
        int[] tailSum = new int[A.length];

        for(int i=1; i<A.length; i++) {
            headSum[i] = Math.max(0, headSum[i-1] + A[i]);
        }

        for(int i=A.length-2; i>=1; i--) {
            tailSum[i] = Math.max(0, tailSum[i+1] + A[i]);
        }

        int maxSum = 0;

        for(int i=1; i<A.length-1; i++) {
            maxSum = Math.max(maxSum, headSum[i-1] + tailSum[i+1]);
        }

        return maxSum;
    }


    public static void main(String args[]) {

        //int A[] = {3, 2, 6, -1, 4, 5, -1, 2};
        //int A[] = {3, 2, 6, -1, 4, 5, -1, 2,9 , 21, -5,22};
        //int A[] = {5,5,5};
        //int A[] = { 5, 17, 0, 3 };
        //int A[] = {6, 1, 5, 6, 4, 2, 9, 4};
        //int A[] = {1,1,1,1,1,-1,-1,-1,-1,1,1,1,-1,1,-1,-1,-1,1,1,1,-1};
        //int A[] = {0, 10, -5, -2, 0};
        int A[] = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};

        MaxDoubleSliceSum max = new MaxDoubleSliceSum();
        System.out.println(max.solution(A));


    }



}
