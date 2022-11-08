package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test02 {

    /*
    A = [3, 8, 9, 7, 6]
    K = 3

([3, 8, 9, 7, 6], 3)

     */

    public static void main(String args[]) {

        int arr[] = {};
        int k = 0% (arr.length == 0 ? 1 : 0);

        System.out.println(k);

        int result[] = new int[arr.length];

        int p = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr.length-k > i) {
                result[i + k] = arr[i];
            } else {
                result[p++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(result));

    }

}
