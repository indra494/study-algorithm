package sort;

import java.util.Arrays;

public class Example01 {
    /* 선택정렬 */

    public static void main(String args[]) {

        int[] arr = {7,1,9,0,3,5,6,2,4,8};

        for(int i=0; i<arr.length; i++) {
            int lowIdx = i;
            for(int j=i; j<arr.length; j++) {
                if(arr[lowIdx] > arr[j]) lowIdx = j;
            }
           // if(arr[i] > arr[lowIdx]) {
                int temp = arr[i];
                arr[i] = arr[lowIdx];
                arr[lowIdx] = temp;
            //}
        }
        System.out.println(Arrays.toString(arr));
    }


}
