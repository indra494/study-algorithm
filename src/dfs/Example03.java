package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example03 {
    /* dfs 예제(깊이우선탐색) */

    public void dfs(List<Integer[]> list, int num, boolean[] checked) {
        checked[num] = true;
        System.out.println(num + "");

        Integer[] arr = list.get(num);
        for(int i=0; i<arr.length; i++){
            if(!checked[arr[i]]) {
                dfs(list, arr[i], checked);
            }
        }
    }

    public static void main(String args[]) {

        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{});
        list.add(new Integer[]{2,3,8});
        list.add(new Integer[]{1,7});
        list.add(new Integer[]{1,4,5});
        list.add(new Integer[]{3,5});
        list.add(new Integer[]{3,4});
        list.add(new Integer[]{7});
        list.add(new Integer[]{2,6,8});
        list.add(new Integer[]{1,7});

        boolean checked[] = new boolean[9];
        Arrays.fill(checked,false);


        Example03 example03 = new Example03();
        example03.dfs(list, 1, checked);

    }

}
