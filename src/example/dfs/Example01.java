package example.dfs;

public class Example01 {
    /* 팩토리얼 구현 */

    public int factorial(int num) {
        if(num <= 1) return 1;
        return num * factorial(num - 1);
    }

    public static void main(String args[]) {
        Example01 example01 = new Example01();
        System.out.println( example01.factorial(5) );

    }

}
