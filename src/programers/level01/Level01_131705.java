package programers.level01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Level01_131705 {

    public int solution(int[] number) {
        int answer = 0;

        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i< number.length; i++) {
            numbers.add(number[i]);
        }

        for(int i = 0; i<numbers.size(); i++) {
            List<Integer> clonedList = numbers.stream().collect(Collectors.toList());
            clonedList.remove(i);
            answer+=this.wow(numbers.get(i),1, clonedList);
        }



        answer = answer;
        answer = answer < 0 ? 0 : answer;

        System.out.println(answer);
        return answer;
    }

    public int wow(int select, int depth, List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i<numbers.size(); i++) {
            int tot = numbers.get(i) + select;

            if(depth == 2 && tot == 0) {
                sum += 1;
            }

            if(depth == 1) {
                List<Integer> clonedList = numbers.stream().collect(Collectors.toList());
                clonedList.remove(i);
                sum += this.wow(tot, depth+1, clonedList);
                return sum;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        Level01_131705 level01_131705 = new Level01_131705();
        level01_131705.solution(number);
    }

}
