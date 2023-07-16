package example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example02 {

    /* 삽입정렬 */
    public static void main(String args[]) {
        Integer[] arr = {7,5,9,0,3,1,6,2,4,8};
        List<Integer> list = new ArrayList<>();
        Arrays.asList(arr).forEach(item->{
            list.add((int)item);
        });

        for(int i=0; i<list.size(); i++) {
            for(int p=i+1; p<list.size(); p++) {
                if (list.get(i) > list.get(p)) {
                    list.add(i, list.get(p));
                    list.remove(p + 1);
                    i = 0;
                }
            }
        }
        list.forEach(System.out::println);

    }

}
