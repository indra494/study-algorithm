package example.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example03 {

    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String inputVal = st.nextToken();

        int sum = 0;
        for(int i=0; i<inputVal.length(); i++) {
            int val = (int)inputVal.charAt(i) - '0';
            if(sum == 0) sum += val;
            else sum *= val;
        }
        System.out.println(sum);
    }
}
