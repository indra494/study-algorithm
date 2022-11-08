package example03;

public class Example02 {

    public int solution(int n, int m, int[] x_axis, int[] y_axis) {
        int answer = 0;

        int[] temp_x_axis = new int[x_axis.length + 2];
        for(int i=0; i<x_axis.length; i++) {
            temp_x_axis[i+1] = x_axis[i];
        }
        temp_x_axis[0] = 0;
        temp_x_axis[temp_x_axis.length - 1] = n;

        int[] temp_y_axis = new int[y_axis.length + 2];
        for(int i=0; i<y_axis.length; i++) {
            temp_y_axis[i+1] = y_axis[i];
        }
        temp_y_axis[0] = 0;
        temp_y_axis[temp_y_axis.length - 1] = m;

        int temp_x;
        int temp_y;
        for(int i=1; i<temp_x_axis.length; i++) {
            temp_x = temp_x_axis[i] - temp_x_axis[i-1];
            for(int j=1; j<temp_y_axis.length; j++) {
                temp_y = temp_y_axis[j] - temp_y_axis[j-1];
                if (answer < (temp_x * temp_y)) {
                    answer = temp_x * temp_y;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Example02 example02 = new Example02();


    }

}
