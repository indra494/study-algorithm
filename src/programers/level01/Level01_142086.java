package programers.level01;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 */
public class Level01_142086 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character,Integer> key = new HashMap<>();
        char sArr[] = s.toCharArray();
        for(int i=0; i<sArr.length; i++) {
            if(key.get(sArr[i]) == null) {
                key.put(sArr[i],i);
                answer[i] = -1;
            } else {
                answer[i] = i - key.get(sArr[i]);
                key.put(sArr[i],i);
            }
        }

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String args[]) {

        String s = "banana";

        Level01_142086 level01 = new Level01_142086();
        level01.solution(s);

    }

}
