package example.dfs;

import java.util.*;

public class Example04 {

    Queue<Integer> queue = new LinkedList<>();

    public void bfs(List<Integer[]> list, int num, boolean checked[]) {
        checked[num] = true;
        queue.offer(num);

        while(!queue.isEmpty()) {

            int queueNum = queue.poll();
            Integer arr[] = list.get(queueNum);

            System.out.println(queueNum + " ");

            for(int i = 0; i<arr.length; i++) {
                if(!checked[arr[i]]) {
                    checked[arr[i]] = true;
                    queue.offer(arr[i]);
                }
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

        Example04 example04 = new Example04();
        example04.bfs(list, 1, checked);
    }
}
