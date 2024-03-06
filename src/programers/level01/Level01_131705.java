package programers.level01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Level01_131705 {

    public Map<Object, Object> map = new HashMap<>();
    public int solution(int[] number) {
        for(int i = 0; i<number.length; i++) {
            int point[] = {-1,-1,-1};
            point[0] = i;
            this.wow(point,1, number);
        }

        return map.size();
    }

    private int wow(int[] point, int depth, int[] number) {

        int sum = 0;

        for(int i = 0; i<number.length; i++) {

            if(check(point,i)) continue;
            point[depth] = i;

            if(depth == 1) {
                this.wow(point, depth+1, number);
            }

            if(depth == 2) {

                int select = number[point[0]] + number[point[1]];
                int tot = number[i] + select;
                if(tot == 0) {
                    int pointCloned[] = Arrays.copyOf(point, point.length);
                    Arrays.sort(pointCloned);
                    String temp = "";
                    for (int k = 0; k < pointCloned.length; k++) {
                        temp += pointCloned[k] + ",";
                    }
                    map.put(temp, "Y");
                }
            }

        }
        return sum;
    }

    private boolean check(int[] point, int value) {
        for(int k=0; k<point.length; k++) {
            if(point[k] == value) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        int[] number = {-2, 3, 0, 2, -5};
        Level01_131705 level01_131705 = new Level01_131705();
        System.out.println(level01_131705.solution(number));
    }

}
