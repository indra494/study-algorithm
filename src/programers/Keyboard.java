package programers;

public class Keyboard {



    public String solution(int[] numbers, String hand) {
        int arr[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;
        for(int i=0; i<numbers.length; i++) {
            int number = numbers[i] == 0 ? 11 : numbers[i];
            if(number % 3 == 1) {
                left = number;
                sb.append("L");
            } else if(number % 3 == 0) {
                right = number;
                sb.append("R");
            } else {
                int leftVal = (int)((number - left) / 3) +  (number - left) % 3;
                leftVal = leftVal < 0 ? leftVal * -1 : leftVal;
                int rightVal = (int)((number - right) / 3) +  (number - right) % 3;
                rightVal = rightVal < 0 ? rightVal * -1 : rightVal;

                System.out.println("#### left :: " + left + ", right :: " + right + " + leftVal ;: " + leftVal + " , rightVal :: " + rightVal);

                if(leftVal > rightVal) {
                    right = number;
                    sb.append("R");
                } else if (rightVal > leftVal) {
                    left = number;
                    sb.append("L");
                } else {
                    if("left".equals(hand)) {
                        left = number;
                        sb.append("L");
                    } else {
                        right = number;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {

        int number[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        Keyboard keyboard = new Keyboard();
        System.out.println(keyboard.solution(number,hand));

    }

}
