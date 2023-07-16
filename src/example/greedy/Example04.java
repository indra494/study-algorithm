package example.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Example04 {

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        List<Integer> list = new ArrayList<Integer>();

        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int count = 0;

        for(int i=0; i<list.size(); i++) {
            int firstIdx = list.indexOf(list.get(i));
            int lastIdx = list.lastIndexOf(list.get(i));
            count += (lastIdx - firstIdx + 1) / list.get(i);
            i = lastIdx + 1;
        }

        System.out.println(count);

    }

}
