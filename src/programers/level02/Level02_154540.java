package programers.level02;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 무인도 여행
 *  ["X591X","X1X5X","X231X", "1XXX1"]
 */
public class Level02_154540 {

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        int[][] arr = new int[maps.length][];
        for(int i=0; i<maps.length; i++) {
            char temp[] = maps[i].toCharArray();
            int[] tempArr = new int[temp.length];
            for(int j=0; j<temp.length; j++) {
                tempArr[j] = (temp[j] == 'X') ? -1 : temp[j] - 48;
            }
            arr[i] = tempArr;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                int value = arr[i][j];
                if(value < 0) continue;

                answer.add(search(arr,i,j));
            }
        }

        if(answer.size() <= 0) answer.add(-1);

        int result[] = answer.stream().sorted((o1, o2) -> {
            if(o1 < o2) return -1;
            else if(o1 > o2) return 1;
            else return 0;
        }).mapToInt(Integer::intValue).toArray();

        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }

        return result;
    }

    public int search(int arr[][], int i, int j) {
        int result = arr[i][j];
        if(result < 0) return 0;
        arr[i][j] = -1;

        if(i > 0 && arr[i-1][j] >= 0) {
            result += search(arr, i-1, j);
        }
        if(i < arr.length-1 && arr[i+1][j] >= 0) {
            result += search(arr, i+1, j);
        }
        if(j < arr[i].length-1 && arr[i][j+1] >= 0) {
            result += search(arr, i, j+1);
        }
        if(j > 0 && arr[i][j-1] >= 0) {
            result += search(arr, i, j-1);
        }

        return result;
    }

    public static void main(String args[]) {

        String[] maps = {"XXX","XXX","XXX"};
        Level02_154540 level02 = new Level02_154540();
        level02.solution(maps);

    }

}
