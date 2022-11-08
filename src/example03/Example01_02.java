package example03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Example01_02 {

    public int solution(int n) {
        int answer = 0;

        int dragonEggCount = 1;
        int dragonCount = 0;
        final int BEFORE_DRAGON_EGG_COUNT = 2;
        int[] beforeDragonEggInfo = new int[] {1, 0};
        final int BEFORE_DRAGON_COUNT = 4;
        int[] beforeDragonInfo = new int[] {0, 0, 0, 0};

        for (int i=1; i<n; i++) {
            dragonCount += beforeDragonEggInfo[i%BEFORE_DRAGON_EGG_COUNT];
            dragonCount -= beforeDragonInfo[i%BEFORE_DRAGON_COUNT];

            beforeDragonEggInfo[i%BEFORE_DRAGON_EGG_COUNT] = dragonEggCount;

            beforeDragonInfo[i%BEFORE_DRAGON_COUNT] = dragonCount;

            if (dragonCount > 0) {
                dragonEggCount += dragonCount;
            }
        }

        return answer;

    }

    public static void main(String args[]) {

        int p[][] = {
                {1,3},
                {3,1},
                {3,5},
                {2,5},
                {5,3}
        };

        Example01_02 example01_01 = new Example01_02();
        System.out.println(6);

    }

}
