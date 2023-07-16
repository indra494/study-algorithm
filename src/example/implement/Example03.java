package example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Example03 {

    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();

        int x = (int)n.charAt(0)-'a';
        int y = n.charAt(1) - '0' - 1;

        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1,-2});
        list.add(new Integer[]{-1,-2});
        list.add(new Integer[]{2,1});
        list.add(new Integer[]{2,-1});
        list.add(new Integer[]{1,2});
        list.add(new Integer[]{-1,2});
        list.add(new Integer[]{-2,1});
        list.add(new Integer[]{-2,-1});

        int cnt = 0;

        for(int i=0; i<list.size(); i++) {
            Integer move[] = list.get(i);
            if(y + move[1] < 0 || y + move[1] >= list.size() || x + move[0] < 0 || x + move[0] >= list.size() ) {
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);

    }

}
