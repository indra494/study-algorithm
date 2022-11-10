package programers;

import java.util.*;

public class Develop {

    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<progresses.length; i++) {
            int pro = progresses[i];
            int speed = speeds[i];
            int day = (int)Math.ceil((float)(100 - pro) / speed);

            if(stack.isEmpty()) {
                stack.push(day);
            } else if(stack.peek() >= day) {
                int cnt = map.get(stack.peek()) == null ? 0 : map.get(stack.peek());
                map.put(stack.peek(),cnt+1);
            } else {
                stack.push(day);
            }
        }

        int result[] = new int[stack.size()];
        for(int i=result.length-1; i>=0; i--) {
            int cnt = map.get(stack.peek()) == null ? 0 : map.get(stack.peek());
            stack.pop();
            result[i] = cnt + 1;
        }

        return result;
    }
/*

1
20
1
1
10
5
 */


    public static void main(String args[]) {

        System.out.println( Math.ceil( (float)95/2) );

        int progress[] = {95, 90, 99, 99, 80, 99};
        int speeds[] = {1, 1, 1, 1, 1, 1};

        Develop develop = new Develop();
        System.out.println(Arrays.toString(develop.solution(progress, speeds)));


    }

}
