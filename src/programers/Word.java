package programers;

import java.util.Locale;

public class Word {

    public int solution(String s) {
        String result = "";

        int groupCnt = 0;
        boolean isFirst = false;
        for(int i=0; i<s.length(); ) {
            int cnt = 1;
            int k = 0;

            String str = "";

            int p = isFirst ? groupCnt : (int)Math.ceil((s.length()-i)/2);
            p = p == 0 ? 1 : p;

            for(int j=p; j>0;) {

                int sEndPoint = (i+j) > s.length()-1 ? s.length() : (i+j);
                int eStartPoint = (i+j+k) > s.length()-1 ? s.length() : (i+j+k);
                int eEndPoint = (i+(j*2)+k) > s.length()-1 ? s.length() : (i+(j*2)+k);

                String start = s.substring(i,sEndPoint);
                String end = s.substring(eStartPoint,eEndPoint);
                str = start;

                if(start.equals(end)) {
                    k=k+j;
                    cnt++;
                } else if(cnt>1) {
                    isFirst = true;
                    groupCnt = j;
                    break;
                } else {
                    if(!isFirst) {
                        if(j==1) {
                            groupCnt = j;
                            isFirst = true;
                        }
                        j--;
                    } else {
                        break;
                    }
                }
            }

            result += cnt + "" + str;
            i = i+(str.length()==0 ? 1 : str.length()) * cnt;

        }
        result = result.replaceAll("1","");
        System.out.println(result);
        return result.length();
    }

    public static void main(String args[]) {

        Word wordCompress = new Word();
        System.out.println(wordCompress.solution("afdeafdefafdeadffddfd"));


    }

}
