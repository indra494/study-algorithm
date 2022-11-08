package codility.lesson6;

import java.util.*;

public class NumberOfDiscIntersections {
/*
 A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0
*/
    public static void main(String args[]) {
        int A[] = {1,5,2,1,4,0};
        int result = 0;

        List<Map<String,Integer>> list = new ArrayList<>();
        for(int i=0; i<A.length; i++) {
            Map<String,Integer> map = new HashMap<>();
            map.put("value",A[i]);
            map.put("number",i);
            list.add(map);
        }

        Collections.sort(list,Comparator.comparing(stringIntegerMap -> {
            return stringIntegerMap.get("value");
        },Collections.reverseOrder()));

        for(int i=0; i<list.size(); i++) {
            Map<String,Integer> smap = list.get(i);
            int sNum = smap.get("number");
            int sVal = smap.get("value");

            for(int j=i+1; j<list.size(); j++) {
                Map<String,Integer> tmap = list.get(j);
                int tNum = tmap.get("number");
                int tVal = tmap.get("value");

                int sLeft = sNum-sVal;
                int sRight = sNum+sVal;
                int tLeft = tNum-tVal;
                int tRight = tNum+tVal;

                if (sLeft <= tLeft && sRight >= tLeft) {
                    result += 1;
                } else if (sLeft <= tRight && sRight >= tRight) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

}
