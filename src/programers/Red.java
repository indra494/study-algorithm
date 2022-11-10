package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Red {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) {
            minHeap.add(scoville[i]);
        }

        while(!minHeap.isEmpty()) {
            int start = minHeap.poll();
            int end = minHeap.isEmpty() ? 0 : minHeap.poll();

            if(start >= K) {
                //answer++;
                break;
            }

            int resultStr = start + (end*2);
            answer++;
            if(!(resultStr >= K) && !minHeap.isEmpty()) {
                minHeap.add(resultStr);
            } else if(minHeap.isEmpty()) {
                answer = 0;
                break;
            }

        }

        return answer;
    }


    public static void main(String args[]) {
        Red red = new Red();
        System.out.println(red.solution(new int[]{1, 2, 3, 9, 10, 12},1));

    }

}
