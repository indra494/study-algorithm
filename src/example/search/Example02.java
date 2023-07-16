package example.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example02 {

    public void start(int arr[], int start, int mid, int end, int find) {

        int totCnt = 0;
        for(int i=0; i<arr.length; i++) {
            totCnt += (arr[i] - mid) < 0 ? 0 : (arr[i] - mid);
        }
        System.out.println("###### start :: " + start + " , mid :: " + mid + ", end :: " + end + ", tot :: " + totCnt);
        if(totCnt == find || start == mid || end == mid ) {
            System.out.println("## find :: " + mid);
            return;
        } else if(totCnt > find) {
            start = mid+1;
            mid = start + ((end-start)/2);
        } else {
            end = mid-1;
            mid = start + ((end-start)/2);
        }

        start(arr,start,mid,end,find);

    }


    public static void main(String args[]) throws Exception {
/*
4 6
19 15 10 17
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

        Example02 example02 = new Example02();
        example02.start(arr,0,(arr[arr.length-1]-1)/2, arr[arr.length-1]-1, m);

        //System.out.println(Arrays.toString(arr));


    }

}
