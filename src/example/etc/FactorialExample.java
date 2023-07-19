package example.etc;

/**
 * factorial(팩토리얼)
 */
public class FactorialExample {
    /* 팩토리얼 구현 */

    public int factorial(int num) {
        if(num <= 1) return 1;
        return num * factorial(num - 1);
    }

    public static void main(String args[]) {
        FactorialExample factorialExample = new FactorialExample();
        System.out.println( factorialExample.factorial(5) );

    }

}
