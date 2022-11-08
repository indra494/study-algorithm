package codility;

public class Test01 {

    public static void main(String args[]) {

        // 5
        int a = 1041;
        String str = Integer.toBinaryString(a);
        System.out.println(str);

        int maxValue = 0;
        int gap = 0;
        while(str.indexOf("1") >= 0) {
            int firstIdx = str.indexOf("1", gap);
            int nextIdx = str.indexOf("1",gap+1);
            gap = nextIdx;

            if(gap < 0) break;

            System.out.println(" gap :: " + gap + " , firstIdx ::" + firstIdx + " nextIdx :: " + nextIdx);

            int tempMaxValue = nextIdx - firstIdx - 1;
            if(maxValue < tempMaxValue) maxValue = tempMaxValue;

        }

       System.out.println(maxValue);

    }

}
