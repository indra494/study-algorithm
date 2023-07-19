import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 인덱스트리
 * input
 * 6
 * 1 3 5 7 9 11
 */

public class IndexTreeExample01 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] input;
    static int[] tree;
    static int NN; // 트리의 깊이. 첫번째 리프노드 인덱스
    static int N; // 입력 받는 값의 갯수

    public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader("in"));
        N = Integer.parseInt(br.readLine());
        NN = 1;
        while (N > NN) {
            NN *= 2;
        }
        tree = new int[NN * 2];
        input = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // NN+i-1 = NN. i=1부터 시작하기 때문
            init(NN + i - 1, input[i]);
        }

        // 1~4 구간의 합
        int value = query(1, 1, NN, 1, 4);

        // 첫번째값 1 > 2로 변경
        updateTree(NN + 1 - 1, 2);

        bw.close();

    }

    // node: 탐색을 시작하려는 node index. 초기화는 루트노드(1)부터 리프노드까지
    private static void init(int node, int value) {
        tree[node] = value;

        // 하위노드 탐색
        while (node > 1) {
            node /= 2;
            // 왼쪽탐색 + 오른쪽 탐색(구간합)
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    // node: 탐색을 시작하려는 node index. 초기화는 루트노드(1)부터 리프노드까지
    // l,r: 실제 트리의 범위
    // ql,qr: 탐색하려는 범위
    private static int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            // 찾으려는 범위 밖의 트리인 경우 무의미한 값 반환
            return 0;
        }

        if (l == r) {
            // 범위 내일 경우
            return tree[node];
        }

        int mid = (l + r) / 2;
        return query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr);
    }

    // node: 탐색을 시작하려는 node index. 업데이트는 값을 바꾸려는 노드. 인덱스트리는 지정가능.
    private static void updateTree(int node, int value) {
        tree[node] = value;
        while (node > 1) {
            node /= 2;
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

    }

}
