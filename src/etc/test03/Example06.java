package etc.test03;

/**
 * [1,1,2,3]  = 3
 * [1,2,4,5]  = 0
 */
public class Example06 {

    public int solution(int[] cookie) {
        int answer = 0;
        if (cookie.length < 2) {
            return answer;
        } else if (cookie.length == 2) {
            if (cookie[0] == cookie[1]) {
                return cookie[0];
            }
            return answer;
        }

        int firstSonPoint = 0;
        int secondSonPoint = firstSonPoint + 1;
        int endPoint = secondSonPoint + 1;
        int cookieLength = cookie.length-2;
        int firstSonBread;
        int secondSonBread;

        for (int i=0; i<cookieLength; i++) {
            firstSonBread = 0;
            for (int j=firstSonPoint; j<secondSonPoint; j++) {
                firstSonBread += cookie[j];
            }

            secondSonBread = 0;
            for (int j=secondSonPoint; j<endPoint; j++) {
                secondSonBread += cookie[j];
            }
            if (firstSonBread == secondSonBread) {
                answer = firstSonBread;
            }
        }

        return answer;
    }

    public static void main(String args[]) {

        int[] cookie = {1,1,2,3};
        Example06 example06 = new Example06();
        example06.solution(cookie);

    }


}
