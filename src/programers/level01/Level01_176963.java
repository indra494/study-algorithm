package programers.level01;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class Level01_176963 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i],yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            int tot = 0;
            for(int j=0; j<photo[i].length; j++) {
                tot += map.get(photo[i][j]) == null ? 0 : map.get(photo[i][j]) ;
            }
            answer[i] = tot;
        }

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }


        return answer;
    }

    public static void main(String[] args) {

        String name[] = {"may", "kein", "kain", "radi"};
        int yearning[] = {5, 10, 1, 3};
        String photo[][] = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        Level01_176963 level = new Level01_176963();
        level.solution(name, yearning, photo);

    }

}
