package etc.test03;

public class Example01 {

    public int solution(int n, int m) {
        int answer = 0;
        for (int i=n; i<m; i++) {
            boolean isPalindrome = isPalindrome(String.valueOf(i));
            if(isPalindrome) {
                answer++;
            }
        }

        System.out.println(answer);

        return answer;
    }

    private boolean isPalindrome(String numberString) {
        int start = 0;
        int end = numberString.length()-1;

        while(start <= end) {
            if(numberString.charAt(start) != numberString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String args[]) {

        int n = 1;
        int m = 100;

        Example01 example01 = new Example01();
        example01.solution(n,m);

    }


}
