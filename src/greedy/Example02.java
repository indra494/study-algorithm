package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example02 {

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;

        while(n > 1) {
            if(n%k > 0) {
                n -= 1;
                count += 1;
            } else {
                n = n / k;
                count += 1;
            }
        }

        System.out.println(count);


    }

}
