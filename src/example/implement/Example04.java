package example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example04 {


    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String in = bf.readLine();
        String arr[] = in.split("");
        Arrays.sort(arr);

        int numCnt = 0;
        String result = "";
        for(int i=0; i<arr.length; i++) {
            char value = arr[i].charAt(0);
            if(Character.isDigit(value)) {
                numCnt += value - '0';
            } else {
                result += value + "";
            }
        }
        System.out.println(result + numCnt);

    }

}
