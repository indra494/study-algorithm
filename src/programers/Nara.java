package programers;

public class Nara {

    public String solution(int n) {
        String answer = "";

        String str = "";

        int value = n;
        while(true) {
            int i = value / 3;
            int k = value % 3;

            if(k==0) {
                str = "4" + str;
                i = i - 1;
            } else {
                str = k + str;
            }

            str = i + str;

            value = Integer.parseInt(str);
            if(i <= 0) break;
       }

        System.out.println(str);


        return answer;
    }

    public static void main(String args[]) {
        Nara nara = new Nara();
        nara.solution(10);
    }

}
