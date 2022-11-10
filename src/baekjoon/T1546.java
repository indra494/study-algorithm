package baekjoon;

import java.util.Scanner;

public class T1546 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arg01 = in.nextInt();
        in.nextLine();
        String line = in.nextLine();

        String arr[] = line.split(" ");
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(Integer.parseInt(arr[i]),max);
        }
        float result = 0;
        for(int i=0; i<arr.length; i++) {
            result += (float)((Float.parseFloat(arr[i])/max) * 100);
        }

        result = result / arr.length;
        System.out.println(result);
    }

}
