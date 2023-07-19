package etc.test03;

public class Example02 {

    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();

        sentence = sentence.toLowerCase();

        int[] alphabetArr = new int[26];

        char setenceArr[] = sentence.toCharArray();
        for(int i=0; i<setenceArr.length; i++) {
            int setenceIdx = setenceArr[i] - 97;
            if(setenceIdx >= 0 && setenceIdx < 26)
                alphabetArr[setenceIdx] = 1;
        }

        boolean isPerfect = true;
        for(int i=0; i<alphabetArr.length; i++) {
            if(alphabetArr[i] <= 0) {
                answer.append((char)(i + 97));
                isPerfect = false;
            }
        }
        if(isPerfect) answer.append("perfect");

        System.out.println(answer.toString());

        return answer.toString();
    }

    public static void main(String args[]) {

        //String sentence = "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";
        String sentence = "Jackdaws love my big sphinx of quartz";
        Example02 example02 = new Example02();
        example02.solution(sentence);

    }



}
