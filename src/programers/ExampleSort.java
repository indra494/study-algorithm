package programers;

import java.util.Arrays;

public class ExampleSort {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int command[] = commands[i];
            int tempArr[] = new int[command[1]-command[0]+1];
            int k=0;
            for(int j=command[0]-1; j<=command[1]-1; j++) {
                tempArr[k++] = array[j];
            }
            Arrays.sort(tempArr);
            answer[i] = tempArr[command[2]-1];
        }

        return answer;
    }

    public static void main(String args[]) {

        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        ExampleSort es = new ExampleSort();
        System.out.println(Arrays.toString(es.solution(array,commands)));


    }

}
