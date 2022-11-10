package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T11660 {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int arg01 = Integer.parseInt(stringTokenizer.nextToken());
        int arg02 = Integer.parseInt(stringTokenizer.nextToken());

        int arr[][] = new int[arg01+1][arg01+1];
        int result[][] = new int[arg01+1][arg01+1];

        for(int i=1; i<=arg01; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1; j<=arg01; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=1; i<=arg01; i++) {
            for(int j=1; j<=arg01; j++) {
                result[i][j] = result[i][j-1] + result[i-1][j] - result[i-1][j-1] + arr[i][j];
            }
        }

        for(int i=0; i<arg02; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x_01 = Integer.parseInt(stringTokenizer.nextToken());
            int y_01 = Integer.parseInt(stringTokenizer.nextToken());
            int x_02 = Integer.parseInt(stringTokenizer.nextToken());
            int y_02 = Integer.parseInt(stringTokenizer.nextToken());

            int sum = result[x_02][y_02] - result[x_01-1][y_02] - result[x_02][y_01-1] + result[x_01-1][y_01-1];
            System.out.println(sum);
        }

    }

}
