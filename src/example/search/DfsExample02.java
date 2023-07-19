package example.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsExample02 {


    public void dfs(int[][] arr, boolean[][] checked, int y, int x, int cnt) {

        if(y == arr.length-1 && x == arr[0].length-1) {
            System.out.println(" :: " + y);
            System.out.println(cnt);
            return;
        }

        checked[y][x] = true;

        int[] moveX = {0,1,0,-1};
        int[] moveY = {-1,0,1,0};

        cnt = cnt + 1;
        for(int i=0; i<4; i++) {
            if( y+moveY[i] < 0 || y+moveY[i] >= arr.length || x+moveX[i] < 0 || x+moveX[i] >= arr[0].length) continue;

            if(!checked[y+moveY[i]][x+moveX[i]] && arr[y+moveY[i]][x+moveX[i]] == 1) {
                dfs(arr,checked,y+moveY[i], x+moveX[i], cnt);
            }
        }
    }

    public static void main(String args[]) throws Exception {



/*
5 6
101010
111111
000001
111111
111111
 */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] arr = new int[y][x];
        for(int i=0; i<y; i++) {
            char[] charArr = bf.readLine().toCharArray();
            for(int j=0; j<charArr.length; j++) {
                arr[i][j] = charArr[j] - '0';
            }
        }

        boolean[][] checked = new boolean[y][x];

        DfsExample02 dfsExample02 = new DfsExample02();
        dfsExample02.dfs(arr, checked, 0, 0, 0);

    }
}
