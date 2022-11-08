package codility.lesson6;

import java.util.HashMap;
import java.util.Map;

public class Distinct {

/*
A[0] = 2 A[1] = 1 A[2] = 1
  A[3] = 2 A[4] = 3 A[5] = 1
 */
    public static void main(String args[]) {
        int A[] = {};

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            map.put(A[i],i);
        }
        int result = map.keySet().size();
        System.out.println(result);

    }

}
