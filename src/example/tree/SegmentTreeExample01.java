import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 세그먼트 트리
 * input
 * 6
 * 1 3 5 7 9 11
 **/
public class SegmentTreeExample01 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] input;
    static int[] tree;
    static int NN; // 트리의 깊이. 첫번째 리프노드 인덱스와 일치하지 않음
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

        init(1, 1, N);

        // 1~4 구간의 합
        int value = query(1, 1, N, 1, 4);

        // 첫번째값 1 > 2로 변경
        updateTree(1, 1, N, 1, 1);

        bw.close();

    }

    // l,r: 탐색범위
    private static int init(int node, int l, int r) {
        if (l == r) {
            // node 관리 구간. 리프노드. l==r(1~1)
            return tree[node] = input[l];
        }

        int mid = (l + r) / 2;
        // 왼쪽탐색 + 오른쪽 탐색(구간합)
        return tree[node] = init(2 * node, l, mid) + init(2 * node + 1, mid + 1, r);
    }

    // node: 탐색을 시작하려는 node index. 초기화는 루트노드(1)부터 리프노드까지
    // l,r: 실제 트리의 범위
    // ql,qr: 탐색하려는 범위
    private static int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            // 찾으려는 범위 밖의 트리인 경우 무의미한 값 반환
            return 0;
        }

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;
        return query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr);
    }

    // node: 탐색을 시작하려는 node index. 초기화는 루트노드(1)부터 리프노드까지
    // l,r: 실제 트리의 범위
    // index: 변경하려는 대상
    // diff: 변경하려는 변화값. 변경값 - 기존값
    private static int updateTree(int node, int l, int r, int index, int diff) {
        if (index < l || r < index) {
            // 찾으려는 범위 밖의 트리인 경우
            return tree[node];
        }
        if (l == r) {
            // 리프노드: l==r(1~1)
            return tree[node] += diff;
        }

        // 리프노드가 아닌 경우 하위노드 탐색.
        int mid = (l + r) / 2;
        return tree[node] = updateTree(2 * node, l, mid, index, diff)
                + updateTree(2 * node + 1, mid + 1, r, index, diff);
    }


}
