package programers;

import java.util.Arrays;

public class NonNumber {

    public int solution(int[] numbers) {
        int total = 0;
        for(int i=0; i<=9; i++) {
            total += i;
        }
        int answer = total - Arrays.stream(numbers).sum();
        return answer;
    }

    public static void main(String args[]) {
        int numbers[] = {1,2,3,4,6,7,8,0};

        NonNumber non = new NonNumber();
        System.out.println(non.solution(numbers));

    }

}
