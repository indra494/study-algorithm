package example.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Example05 {

    public int bfs(List<String[]> list, boolean[][] checked, int y, int x) {
        if(checked[y][x] || Integer.parseInt(list.get(y)[x]) != 0) return 0;

        Queue<Integer[]> queue = new LinkedList<>();
        checked[y][x] = true;
        queue.offer(new Integer[]{y,x});

        int moveX[] = {0,1,0,-1};
        int moveY[] = {-1,0,1,0};
        int cnt = 0;

        while(!queue.isEmpty()) {
            Integer[] p = queue.poll();
            y = p[0];
            x = p[1];

            if(Integer.parseInt(list.get(y)[x]) == 0) {
                cnt++;
                for(int i=0; i<4; i++) {
                    if(x+moveX[i] < 0 || x+moveX[i] >= checked[0].length || y+moveY[i] < 0 || y+moveY[i] >= checked.length) continue;

                    int num = Integer.parseInt(list.get(y + moveY[i])[x + moveX[i]]);

                    if( num == 0 && !checked[y + moveY[i]][x + moveX[i]] ) {
                        queue.offer(new Integer[]{y + moveY[i], x + moveX[i]});
                        checked[y + moveY[i]][x + moveX[i]] = true;
                    }
                }
            }
        }
        return cnt>0 ? 1 : 0;
    }

    public static void main(String args[]) throws Exception {
/*
5 5
000100
011110
011110
011110
011110
000000
 */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<String[]> list = new ArrayList<>();
        for(int i=0; i<y; i++) {
            String line = bf.readLine();
            String[] arr = line.split("");
            list.add(arr);
        }

        boolean checked[][] = new boolean[y][x];
        checked[0][0] = false;

        Example05 example05 = new Example05();

        int result = 0;
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                result += example05.bfs(list, checked, i,j);
            }
        }
        System.out.println(result);
    }

}
