package codility.lesson5;

public class CountDiv {

/*
A = 6, B = 11 및 K = 2
*/
    public static void main(String args[]) {
        int A = 0;
        int B = 2000000000;
        int K = 1;

        int result = (B/K)-((A-1 < 0 ? 0 : A-1)/K);
        if(A == 0) result += 1;

        System.out.println(result);
    }

}
