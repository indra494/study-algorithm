package example.greedy;

public class Example01 {

    public static void main(String args[]) {

        int n = 1260;
        int count = 0;

        int array[] = {500, 100, 50, 10};

        for(int i=0; i<array.length; i++) {
            count += n / array[i];
            n = n % array[i];
        }
        System.out.println(count);
    }


}
