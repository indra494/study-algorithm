package programers.level01;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
 */
public class Level01_135808 {

    public int solution(int k, int m, int[] score) {
        int boxSize = score.length / m;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<score.length; i++) {
            queue.add(score[i]);
        }

        int jumsu = 0;
        int p = 0;
        while(!queue.isEmpty()) {
            int low = 1000000;
            if(boxSize <= p) break;
            for(int i=0; i<m; i++) {
                int value = queue.poll();
                if(value < low) low = value;
            }
            jumsu += (low * m);
            p++;
        }
        return jumsu;
    }

    public static void main(String args[]) {

        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        Level01_135808 level01_135808 = new Level01_135808();
        level01_135808.solution(k,m,score);
    }

}
