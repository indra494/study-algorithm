package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ddang {

    int solution(int[][] land) {

        int t1_maxValue = 0;
        int t1_maxIndex = -1;

        int t2_maxValue = 0;
        int t2_minValue = 0;
        for(int i=0; i<land.length; i++) {
            int row[] = land[i];
            int maxIndex,maxValue,minIndex,minValue;
            maxIndex = maxValue = minIndex = minValue = 0;
            Arrays.sort(row);

            for(int j=0; j<row.length; j++) {
                if(maxValue <= row[j]) {
                    minIndex = maxIndex;
                    minValue = maxValue;
                    maxIndex = j;
                    maxValue = row[j];
                }
            }

            if(t1_maxIndex == maxIndex) {
                if(t2_maxValue-t2_minValue < maxValue-minValue) {
                    t1_maxValue = t1_maxValue - t2_maxValue + t2_minValue;
                    t1_maxIndex = maxIndex;
                    t1_maxValue += maxValue;
                } else {
                    t1_maxIndex = minIndex;
                    t1_maxValue += minValue;
                }

            } else {
                t1_maxIndex = maxIndex;
                t1_maxValue += maxValue;

                t2_maxValue = maxValue;
                t2_minValue = minValue;
            }

        }

        return t1_maxValue;
    }

    public static void main(String args[]) {

        int land[][] = {
                {4, 3, 2, 1},
                {2, 2, 2, 1},
                {6, 6, 6, 4},
                {8, 7, 6, 5},
        };

        Ddang ddang = new Ddang();
        System.out.println(ddang.solution(land));


    }



}
