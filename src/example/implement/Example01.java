package example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Example01 {

    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int dx[] = {0,1,0,-1};
        int dy[] = {-1,0,1,0};

        Map<String,Integer> move = new HashMap<>();
        move.put("U",0);
        move.put("R",1);
        move.put("D",2);
        move.put("L",3);

        int x = 0;
        int y = 0;
        while(st.hasMoreTokens()) {
            int now = move.get(st.nextToken());
            if(x + dx[now] < 0 || x + dx[now] >= n || y + dy[now] < 0 || y + dy[now] >= n) {
                continue;
            }

            x += dx[now];
            y += dy[now];
        }
        x += 1;
        y += 1;
        System.out.println(  y + " " + x);
    }

}
