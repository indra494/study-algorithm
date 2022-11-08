package dfs;

public class Example02 {
    /* 최대공약수(유클리드 호제법) */

    public int gcd(int num01, int num02) {
        if(num01 %num02 == 0) return num02;
        return gcd(num02, num01 % num02);
    }

    public static void main(String args[]) {
        Example02 example02 = new Example02();
        System.out.println(example02.gcd(192,162));
    }

}
