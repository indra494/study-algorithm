package street;

public class Example02_01 {

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
            if(A[i+1] > K) break;
        }
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }

    public static void main(String args[]) {
        //int[] A = {1,1,2,3,4,5,6,7,9,9};
        //int[] A = {1,1,2,2,3,4,7};
        int[] A = {1,1,3};
        int k = 2;

        Example02_01 example02_01 = new Example02_01();
        System.out.println(example02_01.solution(A,k));

    }

}
