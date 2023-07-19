package programers.level01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class Level01_178871 {

    public String[] solution(String[] players, String[] callings) {

        Map<String,Integer> indexMap = new HashMap<>();
        int j = 0;
        for(int i=0; i<callings.length; i++) {
            if(indexMap.get(callings[i]) != null) {
                j = indexMap.get(callings[i]);
            } else {
                j = 0;
            }

            for(; j<players.length; j++) {
                if(callings[i].equals(players[j])) {
                    players[j] = players[j-1];
                    players[j-1] = callings[i];
                    indexMap.put(players[j-1],j-1);
                    break;
                }
                indexMap.put(players[j],j);
            }
        }

        System.out.println(Arrays.stream(players).toList());


        return players;
    }

    public static void main(String args[]) {
        Level01_178871 level01 = new Level01_178871();

        String callings[] = {"kai", "kai", "mine", "mine"};
        String players[] = {"mumu", "soe", "poe", "kai", "mine"};


        level01.solution(players, callings);


    }


}
