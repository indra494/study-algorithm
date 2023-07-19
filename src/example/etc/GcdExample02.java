/**
 * 최대공약수(유클리드호제법)
 */
public class GcdExample02 {

    public int getGdc(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0) {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }

    public static void main(String args[]) {
        GcdExample02 GcdExample02 = new GcdExample02();
        System.out.println( GcdExample02.getGdc(100,400) );

    }

}
