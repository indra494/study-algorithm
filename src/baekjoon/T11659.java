package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T11659 {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int arg01 = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        int arr[] = new int[arg01];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<arg01; i++) {
            arr[i] = (i==0 ? 0 : arr[i-1]) + Integer.parseInt(stringTokenizer.nextToken());
        }

        int result[] = new int[quizNo];
        for(int i=0; i<quizNo; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken())-1;
            int end = Integer.parseInt(stringTokenizer.nextToken())-1;
            result[i] = arr[end] - (start==0 ? 0 : arr[start-1]);
        }

        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
