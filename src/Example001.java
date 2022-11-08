import java.util.Scanner;

public class Example001 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int arg01 = in.nextInt();
        String arg02 = in.next();

        int sum = 0;
        for(int i=0; i<arg01; i++) {
            System.out.println("## :: " + arg02.charAt(i));
            sum += Integer.parseInt(arg02.charAt(i) + "");
        }
        System.out.println("sum :: " + sum);

    }

}
