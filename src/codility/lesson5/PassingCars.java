package codility.lesson5;

import java.util.ArrayList;
import java.util.List;

public class PassingCars {

/*
A[0] = 0
A[1] = 1
A[2] = 0
A[3] = 1
A[4] = 1
*/
    public static void main(String args[]) {

        int A[] = {0,1};
        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=A.length-1; i>=0; i--) {
            cnt = cnt+A[i];
            if(A[i] == 0){
                list.add(cnt);
            }
        }
        cnt = 0;
        for(int i=0; i<list.size(); i++) {
            cnt = cnt + list.get(i);
        }
        cnt = cnt > 1000000000 || cnt < 0 ? -1 : cnt;
        System.out.println(cnt);

    }

}
