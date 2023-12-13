package example.test01;

public class Example03 {

    enum DAYS {
        MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);

        private final int value;

        DAYS(int value) { this.value = value; }

        public int getValue() { return value; }

    };

    public int solution(int leave, String day, int[] holidays) {
        int answer = -1;



        System.out.println(DAYS.SAT.value -  DAYS.valueOf(day).value);
        int gap = DAYS.SAT.value -  DAYS.valueOf(day).value;
        int offset = 0;
        int cal[] = new int[30];
        for(int i=0; i<30; i++) {
            cal[i] = 0;
            if(i==gap || i==gap+1) {
                cal[i] = 1;
                offset = 0;
            } else if (offset == 6 || offset == 7) {
                cal[i] = 1;
                offset = 0;
            }
            offset++;
        }


        for(int i=0; i<cal.length; i++) {
            System.out.println(cal[i]);
        }

        return answer;
    }

    public static void main(String args[]) {

        int leave = 4;
        String day = "FRI";
        int[] holidays = {6,21,23,27,28};


       Example03 example = new Example03();
       example.solution(leave, day, holidays);

    }


}
