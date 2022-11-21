package street;

public class Example02 {

    public boolean solution(int[] A, int K) {
        for (int i=0; i<A.length; i++) {
            if (A[i] == K) {
                return true;
            } else if (A[i] > K) {
                return false;
            }
        }
        return false;
    }

    public static void main(String args[]) {

    }

}
