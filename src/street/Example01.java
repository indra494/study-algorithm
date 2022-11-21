package street;

public class Example01 {

    public int getNumber(int N) {
        String num = Integer.toString(N);
        char numArr[] = num.toCharArray();
        int value = 0;
        for(int i=0; i<numArr.length; i++) {
            value += (numArr[i]) - '0';
        }
        return value;
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int defaultValue = getNumber(N);

        int nextValue = 0;
        int nextN = N+1;
        while(defaultValue != nextValue) {
            int tempValue = getNumber(nextN);
            if(defaultValue==tempValue) {
                nextValue = nextN;
                break;
            }
            nextN++;
        }

        return nextValue;
    }

    public static void main(String args[]){
        //int N = 28;
        //int N = 734;
        //int N = 1990;
        int N = 1000;
        Example01 example01 = new Example01();
        System.out.println( example01.solution(N) );

    }

}
