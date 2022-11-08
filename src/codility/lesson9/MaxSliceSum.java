package codility.lesson9;

public class MaxSliceSum {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = -999999999;
        int sum = 0;

        for(int i=0; i<A.length; i++) {
            sum += A[i]; // -1
            if(result < sum && A[i] <= sum) {
                result = sum;
            } else {
                if(sum < 0 && result > 0) sum = 0;
                else if(A[i] > sum) sum = A[i];
            }

            if(result < sum) result = sum;
        }


        return result;
    }

    public static void main(String args[]) {

        MaxSliceSum slice = new MaxSliceSum();

        int[] A = {3,2,-6,4,0};
        //int[] A = {-2, 2};
        //int[] A = {-10};
        //int[] A = {3, -2, 3};
        //int[] A = {1, -2};
        //int[] A = {-2, 1, -2};
        System.out.println(slice.solution(A));



    }

}
