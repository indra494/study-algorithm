/**
 * 최소공배수 (LCM)
 */
public class LcmExample01 {

    public int geLcm(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return geLcm(b, a % b);
        }
    }

    public static void main(String args[]) {
        LcmExample01 lcmExample01 = new LcmExample01();
        System.out.println( lcmExample01.geLcm(100,400) );

    }

}
