import java.util.Scanner;

public class Example002 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int arg01 = in.nextInt();
        in.nextLine();
        String arg02 = in.nextLine();

        int inputArr[] = Example002.convertInt(arg02);
        int maxValue = Example002.maxValue(inputArr);
        float totalValue = 0;
        for(int i=0; i<inputArr.length; i++) {
            totalValue += ((float)inputArr[i]/maxValue)*100;
        }
        System.out.println("## :: " + totalValue/inputArr.length);

    }

    public static int[] convertInt(String argStr) {
        String strArr[] = argStr.split(" ");
        int returnValue[] = new int[strArr.length];
        for(int i=0; i<strArr.length; i++) {
            returnValue[i] = Integer.parseInt(strArr[i]);
        }
        return returnValue;
    }

    public static int maxValue(int[] argArr) {
        int maxNum = argArr[0];
        for(int i=0; i<argArr.length; i++) {
            if(maxNum < argArr[i]) {
                maxNum = argArr[i];
            }
        }

        return maxNum;
    }


}
