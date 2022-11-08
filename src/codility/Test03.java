package codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test03 {

/*
A[0] = 9 A[1] = 3 A[2] = 9
  A[3] = 3 A[4] = 9 A[5] = 7
  A[6] = 9
 */


    public static void main(String args[]) {

        int arr[] = {9,3,9,3,9,7,9,2};
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++) {
            int cnt = map.get(arr[i]) == null ? 0 : map.get(arr[i]);
            map.put(arr[i],cnt+1);
        }

        int result = 0;
        Iterator it = map.keySet().iterator();
        while(it.hasNext()) {
            int key = (int)it.next();

            if(map.get(key)%2 == 1) {
                result = key;
                break;
            }
        }

        //System.out.println(result);

        /*
        AtomicInteger result = new AtomicInteger();
        map.forEach((key,value) -> {
            if(value%2 == 1) {
                result.set(key);
                return;
            }
        });

        System.out.println(result.get());
         */


/*        int max = Arrays.stream(arr).max().getAsInt();

        int checked[] = new int[max+1];
        for(int i=0; i<arr.length; i++) {
            checked[arr[i]] += 1;
        }

        int result = 0;
        for(int i=0; i<checked.length; i++) {
            if(checked[i] % 2 == 1) {
                result = i;
                break;
            }
        }

        System.out.println(result);*/


    }

}
