package programers;

import java.util.Arrays;

public class Lottos {

    public int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCnt = 0;
        int equalCnt = 0;
        int k = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCnt += 1;
            } else {
                for(int j = k; j<win_nums.length; j++) {
                    if(lottos[i] == win_nums[j]) {
                        k = j;
                        equalCnt += 1;
                        break;
                    }
                }
                if(k == lottos.length-1) break;
            }
        }

        int max = (lottos.length+1) - ( (zeroCnt + equalCnt) == 0 ? 1 : (zeroCnt + equalCnt) );
        int min = (lottos.length+1) - (equalCnt==0 ? 1 : equalCnt);

        return new int[]{max,min};
    }

    public static void main(String args[]) {
            int lottos[] = {45, 4, 35, 20, 3, 9};
            int win_nums[] = {20, 9, 3, 45, 4, 35};

        Lottos lotto = new Lottos();
        System.out.println(Arrays.toString(lotto.solution(lottos, win_nums)));

    }

}
