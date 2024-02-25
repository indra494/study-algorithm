package programers.level01;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class Level01_147355 {

    public int solution(String t, String p) {
        int answer = 0;
        int psize = p.length();

        int huddle = t.length()-(psize-1);
        for(int i=0; i<huddle; i++) {
            String str = t.substring(i,i+psize);
            if(Long.parseLong(str) <= Long.parseLong(p) ) answer++;
        }

        return answer;
    }

    public static void main(String args[]) {

        String t = "500220839878";
        String p = "50022083987";

        Level01_147355 level01_147355 = new Level01_147355();
        System.out.println(level01_147355.solution(t,p));

    }


}
