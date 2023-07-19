package etc.test02;

import java.util.Stack;

public class Example03 {

    public int solution(int[] prices) {
        int max = 0;
        int subMax = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=prices.length-1; i>=0; i--) {
            if(stack.isEmpty()) stack.push(prices[i]);
            else {
                if(stack.peek() < prices[i]) {
                    stack.push(prices[i]);
                } else {
                    while(!stack.isEmpty()) {
                        int pop = stack.pop();
                        if(pop - prices[i] > max) {
                            max = pop - prices[i];
                            subMax = pop;
                        }
                    }
                    System.out.println("### subMax :: " + subMax + " :: max :: " + max);
                    stack.push(subMax);
                }
            }
        }

        /*
        for(int i=0; i<prices.length; i++) {
            for(int j=i; j<prices.length; j++) {
                if(prices[j] - prices[i] > answer) answer = prices[j] - prices[i];
            }
        }*/
        return max;
    }

    public static void main(String args[]) {

        int prices[] = {3, 5, 4, 8, 7};

        Example03 example03 = new Example03();
        System.out.println(example03.solution(prices));




    }


}
