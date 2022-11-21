package street;

import java.util.Arrays;
import java.util.List;

public class demo {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int result = A[A.length-1]+1;
        result = result <= 0 ? 1 : result;

        for(int i=1; i<A.length; i++) {
            if( !(A[i-1] == A[i] || A[i-1] == A[i] - 1) && A[i] > 0 ) {
                result = A[i-1] + 1;
                break;
            }
        }
        return result;
    }


    public static void main(String args[]) {

        // 1 1 2 3 4 6

        int A[] = {1, 3, 6, 4, 1, 2};
        //int A[] = {-1,-3};
        demo demo = new demo();
        System.out.println(demo.solution(A));


    }

}
