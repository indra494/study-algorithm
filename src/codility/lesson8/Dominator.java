package codility.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

/*
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
 */

    public static void main(String args[]) {
        int A[] = {2, 1, 1, 3};

        int lastIdx = 0;
        int lastCnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            int totCnt = (map.get(A[i]) == null ? 1 : map.get(A[i]) +1);
            if(lastCnt < totCnt ) {
                lastCnt = totCnt;
                lastIdx = i;
            }
            map.put(A[i], totCnt);
        }

        if(A.length/2 >= lastCnt || A.length <= 0) lastIdx = -1;

        System.out.println(lastIdx);
    }

}
