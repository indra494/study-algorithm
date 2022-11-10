package baekjoon;

import java.util.Scanner;

public class T2042 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int arg01 = in.nextInt();
        int arg02 = in.nextInt();
        int arg03 = in.nextInt();

        int arr[] = new int[arg01];
        for(int i=0; i<arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int inputArr[][] = new int[arg02+arg03][3];
        for(int i=0; i<arg02+arg03; i++) {
            for(int j=0; j<3; j++) {
                inputArr[i][j] = in.nextInt();
            }
        }

        for(int i=0; i<inputArr.length; i++) {
            if(i%2 == 0) {
                arr[inputArr[i][1]-1] = inputArr[i][2];
            } else {
                int result = 0;
                for(int j=inputArr[i][1]-1; j<inputArr[i][2]; j++) {
                    result += arr[j];
                }
                System.out.println(result);
            }
        }
    }

}
