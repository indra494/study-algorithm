package etc.example03;

public class Example01 {

    public int solution(int [][] p)
    {
        int answer = 0;
        int[] tempValue = {-1, -1};
        for(int i=0; i<p.length; i++) {
            for(int j=i+1; j<p.length; j++) {
                if((p[i][0] == p[j][1]) && (p[i][1] == p[j][0])) {
                    tempValue[0] = p[i+1][0];
                    tempValue[1] = p[i+1][1];

                    p[i+1][0] = p[j][0];
                    p[i+1][1] = p[j][1];

                    p[j][0] = tempValue[0];
                    p[j][1] = tempValue[1];
                    i++;

                    answer++;
                    break;
                }
            }
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

        Example01 example01 = new Example01();
        System.out.println(example01.solution(p));

    }

}
