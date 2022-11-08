package way;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example04 {

    /* 플로이드 워셜 알고리즘(내가한거) */
/*
4 7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */


    public static final int INF = (int) 1e9;
    public static int n,m;
    public static int[][] list = new int[501][501];

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());  // 노드개수
        m = Integer.parseInt(st.nextToken());  // 간선개수

        for(int i=0; i< 501; i++) {
            Arrays.fill(list[i], INF);
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) list[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a][b] = c;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    list[j][k] = Math.min(list[j][k], list[j][i] + list[i][k]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(list[i][j] == INF) {
                    System.out.println("INF");
                } else {
                    System.out.println(list[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
