package programers.level02;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
public class Level02_172927 {

    public int solution(int[] picks, String[] minerals) {
        int point = 0;


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < minerals.length; i++) {
            if ("diamond".equals(minerals[i])) queue.add(1);
            else if ("iron".equals(minerals[i])) queue.add(2);
            else queue.add(3);
        }


        while(!queue.isEmpty()) {

            if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;

            List<Integer> mineralList = new ArrayList();
            for(int i=0; i<5; i++) {
                mineralList.add(queue.poll());
                if(queue.isEmpty()) break;
            }

            int[] point01 = this.doPoint(picks[0] > 0 ? 1 : 99999,mineralList);
            int[] point02 = this.doPoint(picks[1] > 0 ? 2 : 99999,mineralList);
            int[] point03 = this.doPoint(picks[2] > 0 ? 3 : 99999,mineralList);

            System.out.println(" ## point01 ;: " + point01[0] + "  , " + point01[1]);
            System.out.println(" ## point02 ;: " + point02[0] + "  , " + point02[1]);
            System.out.println(" ## point03 ;: " + point03[0] + "  , " + point03[1]);

            int index = 0;
            int indexResult = 0;
            int indexGap = 0;

            if(point01[0] / point01[1] < point02[0] / point02[1]) {
                index = 1;
                indexResult = point02[0];
                indexGap = point02[1];
            } else {
                index = 0;
                indexResult = point01[0];
                indexGap = point01[1];
            }

            if(point03[0] / point03[1] > indexGap) {
                index = 2;
                indexResult = point03[0];
                indexGap = point03[1];
            }

            System.out.println("##################### :: " + indexGap);
            System.out.println("########### 1234 :: " + indexResult);


            /*
            if(point01[0] > point02[0]) {
                index = 1;
                indexResult = point02[0];
            } else {
                index = 0;
                indexResult = point01[0];
            }

            if(point03[0] < indexResult) {
                index = 2;
                indexResult = point03[0];
            }
            */


            picks[index] -= 1;

            point += indexResult;

            System.out.println("qqq :: " + point);

        }

        return point;
    }

    public int[] doPoint(int pick, List<Integer> mineralList) {

        int[] point = {0,0};
        int gap = 0;

        List<Integer> pickList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pickList.add(pick);
        }

        int j = 0;
        for (int i = 0; i < pickList.size(); i++) {
            if(mineralList.size() <= j) break;

            int tempPoint = pickList.get(i) - mineralList.get(j);
            if (tempPoint > 0) {
                point[0] += (Math.pow(5, tempPoint));
            } else {
                point[0] += 1;
            }
            point[1] += tempPoint;
            j++;
        }
        if(pick >= 99999) point[1] = -99999;

        return point;

    }


    public static void main(String args[]) {
        // 3 + 5 + (25)
        // 1 + 1 + 5 + 1 + 25 =

        int picks[] = {1,3,2};
        String minerals[] = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        Level02_172927 level02 = new Level02_172927();
        System.out.println(" ### :: " + level02.solution(picks, minerals));


    }

}
