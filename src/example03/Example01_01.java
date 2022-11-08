package example03;

import java.util.HashMap;
import java.util.Map;

public class Example01_01 {

    public int solution(int [][] p)
    {
        int answer = 0;

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<p.length; i++) {

            if( map.get(p[i][0] + "_" + p[i][1]) != null || map.get(p[i][1] + "_" + p[i][0]) != null ) {
                answer++;
            }

            map.put(p[i][0] + "_" + p[i][1],1);
            map.put(p[i][1] + "_" + p[i][0],1);
        }
        return answer;
    }
    public static void main(String args[]) {

        int p[][] = {
                {1,3},
                {3,1},
                {3,5},
                {2,5},
                {5,3}
        };

        Example01_01 example01_01 = new Example01_01();
        System.out.println(example01_01.solution(p));

    }

}
