package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleMath {

    public int[] solution(int[] answers) {
        int tester01[] = {1,2,3,4,5};
        int tester02[] = {2,1,2,3,2,4,2,5};
        int tester03[] = {3,3,1,1,2,2,4,4,5,5};

        int sort[] = {0,0,0};
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == tester01[i% tester01.length]) {
                sort[0] += 1;
            }
            if(answers[i] == tester02[i% tester02.length]) {
                sort[1] += 1;
            }
            if(answers[i] == tester03[i% tester03.length]) {
                sort[2] += 1;
            }
        }
        int max = Arrays.stream(sort).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<sort.length; i++) {
            if(max == sort[i]) {
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String args[]) {
        int answers[] = {3, 3, 2, 1, 5};
        ExampleMath math = new ExampleMath();
        System.out.println(Arrays.toString(math.solution(answers)));
    }

}
