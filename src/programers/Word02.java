package programers;

public class Word02 {

    public int solution(String s) {


        String string;
        string = s;
        int stringLength = string.length();
        int count;

        StringBuilder builder;
        int lenght = 1;
        int checkLength;
        boolean isEqual;
        String tempString = "";
        String resultString = "";

        int minCount = Integer.MAX_VALUE;
        for (; lenght<=stringLength; lenght++) {
            checkLength = lenght * 2;
            builder = new StringBuilder(string);
            resultString = "";
            count = 1;
            while (lenght <= builder.length()) {
                if (builder.length() == lenght) {
                    tempString = builder.substring(0, lenght);
                    resultString += (count>1?("" + count + tempString):("" + tempString));

                    builder.delete(0, lenght);
                    break;
                }
                if (builder.length() < checkLength) {
                    if (count == 1) {
                        resultString += builder.toString();
                    } else {
                        tempString = builder.substring(0, lenght);
                        builder.delete(0, lenght);

                        resultString += (count + tempString + builder);
                    }
                    break;
                }

                isEqual = true;
                for (int i=lenght; i<(checkLength); i++) {
                    if (builder.charAt(i - lenght) != builder.charAt(i)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    count++;
                } else {
                    tempString = builder.substring(0, lenght);
                    resultString += (count>1?("" + count + tempString):("" + tempString));
                    count = 1;
                }
                builder.delete(0, lenght);
            }
            if (minCount > resultString.length()) {
                minCount = resultString.length();
            }
        }
        return minCount;
    }

    public static void main(String args[]) {

        Word02 word02 = new Word02();
        System.out.println( word02.solution("abdfddfedededed") );

    }

}
