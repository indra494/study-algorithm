package etc.test03;

public class Example05 {

    public int solution(int[] bricks) {
        int answer = 0;
        int start = 0;
        int end = 0;

        for(int i=0; i < bricks.length-1; i++) {
            start = 0;
            end = 0;
            for(int j = 0; j < i; j++) {
                start = bricks[j] > start ? bricks[j] : start;
            }
            for(int j = i + 1; j < bricks.length; j++) {
                end = bricks[j] > end ? bricks[j] : end;
            }

            if(bricks[i] < start && bricks[i] < end) {
                answer += (start < end ? start : end) - bricks[i];
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String args[]) {

        int brikcs[] = {0, 2, 0, 1, 3, 1, 2, 0, 1, 0, 2, 0};
        //int brikcs[] = {1,2,3,4,5,6,7};

        Example05 example = new Example05();
        example.solution(brikcs);

    }


}
