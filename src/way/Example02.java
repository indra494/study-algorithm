package way;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Item {
    int num;
    int way;

    public Item(int _num, int _way) {
        num = _num;
        way = _way;
    }

    public int getNum() {
        return num;
    }

    public int getWay() {
        return way;
    }
}

public class Example02 {

    /*
    다익스트라 걍 외워야겠다.
     */

    public static final int INF = (int)1e9;

    public static int n, m, start;
    public static List<List<Item>> list = new ArrayList<>();

    public static boolean[] checked = new boolean[10001];
    public static int[] table = new int[10001];

    public void start() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        table[start] = 0;

        for(int i=0; i<list.get(start).size(); i++) {
            table[list.get(start).get(i).getNum()] = list.get(start).get(i).getWay();
        }

        for(int i=0; i<n-1; i++) {
            int nodeIdx = getShortNode();
            checked[nodeIdx] = true;

            for(int j=0; j<list.get(nodeIdx).size(); j++) {
                int cost = table[nodeIdx] + list.get(nodeIdx).get(j).getWay();
                if(cost < table[list.get(nodeIdx).get(j).getNum()]) {
                    table[list.get(nodeIdx).get(j).getNum()] = cost;
                }
            }

            System.out.println(" ### :: " + nodeIdx);
        }
    }

    public int getShortNode() {
        int min = INF;
        int idx = 0;
        for(int i=1; i<n; i++) {
            if( table[i] < min && !checked[i]) {
                min = table[i];
                idx = i;
            }
        }
        return idx;
    }

/*
6 11 1
1 2 2
1 4 1
1 3 5
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());  // 노드개수
        m = Integer.parseInt(st.nextToken());  // 간선개수
        start = Integer.parseInt(st.nextToken()); // 시작번호

        /* 노드 초기화 */
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<Item>());
        }
        Arrays.fill(table,INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Item(b,c));
        }

        Example02 example02 = new Example02();
        example02.start();


        for(int i=1; i<=n; i++) {
            if(table[i] == INF) {
                System.out.println(" what??");
            } else {
                System.out.println(table[i]);
            }
        }

    }

}
