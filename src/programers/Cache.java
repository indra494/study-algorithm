package programers;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    static final int HIT_TIME = 1;
    static final int MISS_TIME = 5;
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        List<String> list = new ArrayList<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();

            if(list.size() > cacheSize) list.remove(0);

            if(!list.contains(city)) {
                totalTime += MISS_TIME;
                list.add(city);
            } else {
                totalTime += HIT_TIME;
                list.remove(city);
                list.add(city);
            }
        }
        return totalTime;
    }

    public static void main(String args[]) {

        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        Cache cache = new Cache();
        System.out.println(cache.solution(cacheSize,cities));

    }





}
