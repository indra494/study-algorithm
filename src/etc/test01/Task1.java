package etc.test01;

public class Task1 {
    public static void main(String args[]) {

        int N = 999999999;

        if(N <10) {
            System.out.println(0);
            return;
        }

        int len = (int)Math.log10(N)+1;
        StringBuilder str = new StringBuilder("1");
        for(int i=0; i<len-1; i++) {
            str.append("0");
        }
        int div = Integer.parseInt(str.toString());
        //nt result = N - (N%div);

        System.out.println( div );
    }

    public int solution(int N) {
        // write your code in Java SE 8
        if(N <10) {
            return 0;
        }

        int len = (int)Math.log10(N)+1;
        StringBuilder str = new StringBuilder("1");
        for(int i=0; i<len-1; i++) {
            str.append("0");
        }
        int result = Integer.parseInt(str.toString());
        return result;
    }

}
