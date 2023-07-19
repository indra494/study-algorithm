package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10986
 * 나머지합
 * 5 3
 * 1 2 3 1 2
 */
public class Baekjoon_10986 {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int arg01 = Integer.parseInt(stringTokenizer.nextToken());
        int arg02 = Integer.parseInt(stringTokenizer.nextToken());

        int arr[] = new int[arg01];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<arg01; i++) {
            arr[i] = (i==0 ? 0 : arr[i-1]) + Integer.parseInt(stringTokenizer.nextToken());
        }



        for(int i=0; i<arr.length; i++) {
            System.out.println(  arr[i] );
        }


    }


}
