package etc.test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String args[]) {

        String pattern = "\\d+(\\.\\d+){0,2}(-SNAPSHOT)?";
        if(!Pattern.matches(pattern, "")) {
            throw new IllegalArgumentException("");
        }

        SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.GERMAN);
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Warsaw");
        ISO8601DATEFORMAT.setTimeZone(timeZone);
        Date now = new Date();

        System.out.println(ISO8601DATEFORMAT.format(now)+"Z");

        Map<String,Object> map = new HashMap<>();

        int A[] = {1};

        int seqSum = 0;
        int arrSum = 0;

        for(int i=1; i<=A.length; i++) {
            seqSum += i;
        }

        for(int i=0; i<A.length; i++) {
            arrSum += A[i];
        }

        int result = seqSum - arrSum;
        result = result < 0 ? result*-1 : result;

        System.out.println(result);

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int seqSum = 0;
        int arrSum = 0;

        for(int i=1; i<=A.length; i++) {
            seqSum += i;
        }

        for(int i=0; i<A.length; i++) {
            arrSum += A[i];
        }

        int result = seqSum - arrSum;
        result = result < 0 ? result*-1 : result;

        return result;
    }

}
