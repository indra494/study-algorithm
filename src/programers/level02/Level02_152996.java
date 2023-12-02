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

        long array[] = new long[1001];

        for(int i=0; i<weights.length; i++) {
            array[weights[i]] += 1;
        }

        List<Integer> distanceList = new ArrayList<>();
        distanceList.add(2);
        distanceList.add(3);
        distanceList.add(4);
        for(int i=100; i<array.length; i++) {
            if( array[i] == 0) continue;

            if(array[i] > 1) {
                answer += (((double)array[i] / 2) * (array[i] + 1)) - array[i];
            }


            for(int j=i+1; j<array.length; j++) {

                if (array[j] == 0) continue;

                int gcd = getGcd(i, j);
                int startWeight = j/gcd;
                int endWeight = i/gcd;

                if(startWeight == 1 || endWeight == 1) {
                    startWeight = startWeight * 2;
                    endWeight = endWeight * 2;
                }

                System.out.println("### i :: " + i + "  , j :: " + j);
                System.out.println(" ----> " + startWeight + "  , " + endWeight);

                if(startWeight - endWeight == 3) continue;

                if(distanceList.contains(startWeight) && distanceList.contains(endWeight)) {
                    answer += array[i] * array[j];
                } else if(startWeight == 1 || endWeight == 1) {
                    if(startWeight * 2 <= 4 && endWeight * 2 <= 4) answer +=1;
                }

            }
        }
        System.out.println(answer);
        return answer;
    }



    public long solution2(int[] weights) {
        long answer = 0;
        List<Integer> distanceList = new ArrayList<>();
        distanceList.add(2);
        distanceList.add(3);
        distanceList.add(4);

        Arrays.sort(weights);

        for(int i=0; i<weights.length-1; i++) {
            for(int j=i+1; j<weights.length; j++) {

                if(weights[i] == weights[j]) {
                    answer += 1;
                    continue;
                }

                int gcd = getGcd(weights[i], weights[j]);
                int startWeight = weights[i]/gcd;
                int endWeight = weights[j]/gcd;

                System.out.println("####################");
                System.out.println(startWeight);
                System.out.println(endWeight);

                if(distanceList.contains(startWeight) && distanceList.contains(endWeight)) {
                    answer +=1;
                } else if(startWeight == 1 || endWeight == 1) {
                    if(startWeight * 2 <= 4 && endWeight * 2 <= 4) answer +=1;
                }

                if(weights[i]*4 < weights[j]) break;
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
