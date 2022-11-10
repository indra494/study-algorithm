package programers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Course {

    final static int CUT_VAL = 65;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = new String[course.length];

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<orders.length; i++) {
            String table = orders[i].toUpperCase();
            char[] tableArr = table.toCharArray();
            Arrays.sort(tableArr);

            for(int j=0; j<course.length; j++) {
                for(int k=0; k<tableArr.length; k++) {


                }
            }
        }

        return answer;
    }

    public static void main(String args[]) {

        String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "CBFG", "ACDEH"};
        int cours[] = {2,3,4};

        Course c = new Course();

        System.out.println("ABC" + "AB");

        //System.out.println(Arrays.toString(c.solution(orders, cours)));
    }

}
