package codility;

import java.util.HashMap;
import java.util.Map;

public class Test07 {

    /*
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
     */

    public static void main(String args[]) {
        int A[] = {1,3,1,4,2,3,5,4};
        int X = 5;

        Map<Integer,Integer> map = new HashMap<>();

        int result = -1;
        for(int i=0; i<A.length; i++) {
            if(A[i] <= X) {
                map.put(A[i],i);
            }

            if(map.size() == X) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }

}
