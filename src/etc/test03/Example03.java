package etc.test03;

public class Example03 {

    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];

/*
        for(int i=0; i<grade.length; i++) {
            int order = 1;

            if(i!=0 && grade[i] == grade[i-1]) {
                answer[i] = answer[i-1];
                continue;
            }

            for(int j=0; j<grade.length; j++) {

                if(grade[i] < grade[j]) {
                    order++;
                }
            }
            answer[i] = order;
        }
*/
        for(int i=0; i<grade.length; i++){
            answer[i] = 1;
        }
        for(int i=0; i<grade.length; i++){
            for(int j=0; j<grade.length; j++){
                if(grade[i]<grade[j]){
                    answer[i]++;
                }
            }
        }


        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String args[]) {

        int[] grade = {3,2,1,2};

        Example03 example = new Example03();
        example.solution(grade);

    }

}
