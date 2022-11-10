package programers;

public class Nemo {

    public long solution(int w, int h) {
        long a = w;
        long b = h;
        while(b != 0) {
            long r = a % b;	// 나머지
            a = b;
            b = r;
        }
        return (w*h)-((w+h)-a);
    }

    public static void main(String args[]) {

        Nemo nemo = new Nemo();
        System.out.println(nemo.solution(8,12));

    }
}
