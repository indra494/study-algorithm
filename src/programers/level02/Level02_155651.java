package programers.level02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
 * 호텔 대실
 * [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
 */
public class Level02_155651 {

    public int solution(String[][] book_time) {

        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] < o2[0]) return -1;
                else if(o1[0] > o2[0]) return 1;
                else return 0;
            }
        });

        long[][] bookTime = new long[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            bookTime[i][0] = convertMiniute(book_time[i][0]);
            bookTime[i][1] = convertMiniute(book_time[i][1]);
            queue.add(bookTime[i]);
        }

        List<long[]> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            long[] outsideObject = queue.poll();

            boolean isEmpty = true;

            for (int i = 0; i < list.size(); i++) {
                long[] insdieObject = list.get(i);
                if(insdieObject[1]+10 <= outsideObject[0]) {
                    list.remove(insdieObject);
                    list.add(outsideObject);
                    isEmpty = false;
                    break;
                }
            }
            if(isEmpty) list.add(outsideObject);
        }
        System.out.println();

        return list.size();
    }


    public long convertMiniute(String time) {
        String timeArr[] = time.split(":");
        return (Long.parseLong(timeArr[0])*60) + Long.parseLong(timeArr[1]);
    }

    public static void main(String args[]) {

        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        Level02_155651 level02 = new Level02_155651();
        level02.solution(book_time);

    }

}
