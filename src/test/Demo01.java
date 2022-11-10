package test;

import java.util.Arrays;

public class Demo01 {

/*
1, 3, 6, 4, 1, 2

 */

    public static void main(String args[]) {
        int A[] = {-3, -5};
        Arrays.sort(A);

        int result = 1;
        for(int i=1; i<A.length; i++) {
            if(A[i] - A[i-1] > 1 && A[i] > 0) {
                result = A[i] - 1;
                break;
            } else if(i==A.length-1 && A[i] > 0) {
                result = A.length+1;
            }
        }

        System.out.println(result);

    }

}
