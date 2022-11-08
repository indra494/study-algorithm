package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

public class Example04 {
/*
5 3
1 2 5 4 3
5 5 6 6 5
*/
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String strArr1[] = bf.readLine().split(" ");
        String strArr2[] = bf.readLine().split(" ");

        Arrays.stream(strArr1).map(item->Integer.parseInt(item)).sorted();
        Arrays.stream(strArr2).map(item->Integer.parseInt(item)).sorted();

        int last = strArr2.length-1;
        for(int i=k-1; i>=0; i--) {
            if( Integer.parseInt(strArr1[i]) < Integer.parseInt(strArr2[last])) {
                String temp = strArr1[i];
                strArr1[i] = strArr2[last];
                strArr2[last--] = temp;
            }
        }
        Optional<String> total = Arrays.stream(strArr1).reduce((item1, item2)->{
            return Integer.toString((Integer.parseInt(item1) + Integer.parseInt(item2)));
        });

        System.out.println(total.get());

    }
}
