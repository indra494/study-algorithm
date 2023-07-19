package programers.level02;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 뒤에 있는 큰 수 찾기
 * {9, 1, 5, 3, 6, 2}
 */

public class Level02_154539 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int[] checks = new int[numbers.length];
        int[] max = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            answer[i] = -1;
            checks[i] = 0;
            if(i!=0 && numbers[i] == numbers[i-1]) {
                checks[i] = 1;
            }

            max[numbers.length-1] = numbers[numbers.length-1];
            if(i > 0 && numbers[numbers.length-1-i] > max[numbers.length-i]) {
                max[numbers.length-1-i] = numbers[numbers.length-1-i];
            } else if(i > 0 && numbers[numbers.length-1-i] <= max[numbers.length-i]) {
                max[numbers.length-1-i] = max[numbers.length-i];
            }
        }

        int tempValue = 0;
        for(int i=0; i<numbers.length; i++) {
            if(checks[i] == 1 && numbers[i] < tempValue) {
                answer[i] = tempValue;
                continue;
            }
            if(numbers[i] >= max[i] ) {
                answer[i] = -1;
                continue;
            }

            tempValue = 0;
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    tempValue = numbers[j];
                    break;
                }
                if(numbers[i] >= numbers[j] && numbers[i] < answer[j]) {
                    answer[i] = answer[j];
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        int[] numbers = {9, 1, 5, 3, 6, 2, 99, 98,96, 94, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 101};
        Level02_154539 level02 = new Level02_154539();
        level02.solution(numbers);
    }


}
