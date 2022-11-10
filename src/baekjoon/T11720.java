package baekjoon;

import java.util.Scanner;

public class T11720 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arg01 = in.nextInt();
        String arg02 = in.next();

        int result = 0;
        for(int i=0; i<arg02.length(); i++){
            result += (int)arg02.charAt(i) - 48;
        }
        System.out.println(result);
    }

}
