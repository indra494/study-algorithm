package etc.test00;

import java.util.Scanner;

public class Example003 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int sum = 0;

        int arg01[] = new int[2];
        arg01[0] = in.nextInt();
        arg01[1] = in.nextInt();

        int sumArr[] = new int[arg01[0]];
        int arg02[] = new int[arg01[0]];
        for(int i=0; i<arg02.length; i++) {
            arg02[i] = in.nextInt();
            if(i==0) {
                sumArr[i] = arg02[i];
            } else {
                sumArr[i] += sumArr[i - 1] + arg02[i];
            }
        }

        int arg03[][] = new int[arg01[1]][2];
        for(int i=0; i<arg01[1]; i++) {
            for(int j=0; j<2; j++) {
                arg03[i][j] = in.nextInt();
            }
        }

        long beforeTime = System.currentTimeMillis();


        for(int i=0; i<arg03.length; i++) {
            if(arg03[i][0]-1 == 0) System.out.println("## :: " + sumArr[arg03[i][1] -1] );
            else System.out.println("## :: " + (sumArr[arg03[i][1] -1]  - sumArr[arg03[i][0]-2]) );
        }

        long afterTime = System.currentTimeMillis();
        float secDiffTime = (float)(afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+ secDiffTime);


    }

}
