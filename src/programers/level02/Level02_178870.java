package programers.level02;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 연속된 부분 수열의 합
 * [1, 2, 3, 4, 5]	7
 */
public class Level02_178870 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};

        if(sequence[0] == k) {
            return answer;
        }

        int firstIdx = 0;
        int lastIdx = 1;

        int small = Integer.MAX_VALUE;
        int sum = sequence[firstIdx];
        while(true) {
            if(lastIdx >= sequence.length) break;

            sum += sequence[lastIdx];
            if(sum == k) {
                if(lastIdx - firstIdx < small) {
                    small = lastIdx - firstIdx;
                    answer[0] = firstIdx;
                    answer[1] = lastIdx;
                }
                if(small == 0) break;
                lastIdx += 1;
            } else if(sum < k) {
                lastIdx += 1;
            } else if(sum > k) {
                sum -= (sequence[firstIdx] + sequence[lastIdx]);
                firstIdx += 1;
            }
        }

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String args[]) {

        int[] sequence = {1, 1, 1};
        int k = 5;

        Level02_178870 level02 = new Level02_178870();
        level02.solution(sequence, k);

    }


}
