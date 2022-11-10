package programers;

import java.util.*;

public class OpenKaKao {

    public static final String CMD_ENTER = "Enter";
    public static final String CMD_LEAVE = "Leave";
    public static final String CMD_CHANGE = "Change";

    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        int idx = 0;
        for(int i=0; i<record.length; i++) {
            String arr[] = record[i].split(" ");
            String beName = map.get(arr[1]) != null ? map.get(arr[1]).toString() : null;
            List<Integer> indexList = map.get(arr[1]+"_index") != null ? (ArrayList<Integer>)map.get(arr[1]+"_index") : new ArrayList<>();
            if(CMD_ENTER.equals(arr[0]) || CMD_CHANGE.equals(arr[0])) {

                for(int j=0; j<indexList.size(); j++ ){
                    int tempIdx = indexList.get(j);
                    list.set(tempIdx,list.get(tempIdx).replace(beName,arr[2]));
                }
                map.put(arr[1],arr[2]);

                if(CMD_ENTER.equals(arr[0])) {
                    indexList.add(idx++);
                    map.put(arr[1]+"_index",indexList);
                    list.add(arr[2] + "님이 들어왔습니다.");
                }
            } else if(CMD_LEAVE.equals(arr[0])) {
                list.add(beName + "님이 나갔습니다.");
                indexList.add(idx++);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String args[]) {

        String record[] = {"Enter uid1234 Muzi", "Change uid1234 Muzi", "Leave uid1234", "Enter uid1234 Prodo"};

        OpenKaKao open = new OpenKaKao();
        System.out.println(Arrays.toString(open.solution(record)));


    }
}
