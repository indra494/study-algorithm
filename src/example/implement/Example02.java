package example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example02 {

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int count = 0;
        for(int h=0; h<=n; h++) {
            for (int i = 0; i < 60; i++) {
                for (int j = 0; j < 60; j++) {
                    if (  (Integer.toString(h) + Integer.toString(i) + Integer.toString(j)).indexOf("3") >= 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }

}
