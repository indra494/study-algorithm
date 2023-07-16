package example.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example03 {


    public static void main(String args[]) throws Exception {
/*
7 2
2 1 2 2 2 2 3
 */


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println("## :: " + ((sb.lastIndexOf(Integer.toString(m)) - sb.indexOf(Integer.toString(m))) + 1) );


    }

}
