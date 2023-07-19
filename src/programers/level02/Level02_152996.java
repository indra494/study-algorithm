package programers.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 시소 짝꿍
 * [100,180,360,100,270]
 */
public class Level02_152996 {

    public long solution(int[] weights) {
        long answer = 0;
        List<Integer> distanceList = new ArrayList<>();
        distanceList.add(2);
        distanceList.add(3);
        distanceList.add(4);

        Arrays.sort(weights);

        for(int i=0; i<weights.length-1; i++) {
            for(int j=i+1; j<weights.length; j++) {
                int gcd = getGcd(weights[i], weights[j]);
                int startWeight = weights[i]/gcd;
                int endWeight = weights[j]/gcd;

                //System.out.println("############ :: " + weights[i] + " :: " + weights[j]);
                //System.out.println("## :: " + startWeight + " :: " + endWeight + " :: " + gcd);


                if(weights[i] == weights[j]) {
                    answer += 1;
                } else if(distanceList.contains(startWeight) && distanceList.contains(endWeight)) {
                    answer +=1;
                } else if(startWeight == 1 || endWeight == 1) {
                    if(startWeight * 2 <= 4 && endWeight * 2 <= 4) answer +=1;
                }
            }
        }

        System.out.println(answer);

        return answer;
    }

    public int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b);
        }
    }

    public static void main(String args[]) {

        int[] weights = {100,180,360,100,270};
        Level02_152996 level02 = new Level02_152996();
        level02.solution(weights);

        //System.out.println( level02.getGcd(100,400) );

    }

}
