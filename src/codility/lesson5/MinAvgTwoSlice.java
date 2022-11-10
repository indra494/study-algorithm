package codility.lesson5;

public class MinAvgTwoSlice {

    public int solution2(int[] A) {
        // write your code in Java SE 8
        float result = 999999999;
        int idx = 0;
        for(int i=0; i<A.length; i++) {
            int sum = A[i];
            float avg = 0;
            int cnt = 2;
            for(int j=i+1; j<A.length; j++) {
                sum += A[j];
                avg = (float)sum / cnt;
                if(result > avg) {
                    result = avg;
                    idx = i;
                }
                cnt++;
            }
        }

        return idx;
    }

    public int solution(int[] A) {
        float min = 999999999;
        int result = 0;
        for(int i=0; i<A.length-1; i++) {
            if(min > (float)(A[i] + A[i+1]) / 2) {
                min = (float)(A[i] + A[i+1]) / 2;
                result = i;
            }
        }

        for(int i=0; i<A.length-2; i++) {
            if(min > (float)(A[i] + A[i+1] + A[i+2]) / 3) {
                min = (float)(A[i] + A[i+1] + A[i+2]) / 3;
                result = i;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        //int A[] = {4,2,2,5,1,5,8};
        int A[] = {-3, -5, -8, -4, -10};



        MinAvgTwoSlice min = new MinAvgTwoSlice();
        System.out.print(min.solution(A));
    }

}
