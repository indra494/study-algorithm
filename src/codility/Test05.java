package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test05 {
/*
A[0] = 2
A[1] = 3
A[2] = 1
A[3] = 5
 */


    public static void main(String args[]) throws Exception {
        int A[] = {1,2,3,5};

        Arrays.sort(A);

        int result = A.length+1;
        for(int i=0; i<A.length; i++) {
            if(A[i] != i+1) {
                result = i+1;
                break;
            }
        }

        System.out.println(result);

    }


}
