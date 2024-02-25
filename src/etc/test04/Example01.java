package etc.test04;

import java.util.*;

public class Example01 {

        class UserInfo extends HashMap<String,String> {
            int count = 0;
        }

        public String[] solution(String[] records, int k, String date) {
            Map<String, etc.test04.Example01.UserInfo> rePurchase = new HashMap<>();
            Map<String, etc.test04.Example01.UserInfo> purchase = new HashMap<>();
            HashSet<String> productList = new HashSet<>();

            /* 기간내 해당하는 상품만 가공 + (한번구매,재구매 데이터 생성) */
            int compareDate = convertDateToDay(date);
            for(int i = 0; i<records.length; i++) {
                int recordDay = convertDateToDay(records[i].substring(0,10));
                if(recordDay <= compareDate && recordDay > (compareDate-k)) {
                    /* 한번구매, 재구매 데이터 생성 */
                    productList.add(doProcess(records[i], purchase, rePurchase));
                }
            }

            /* 정렬을 위해 우선순위 큐 생성 */
            PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(Double.parseDouble(o1[1]) < Double.parseDouble(o2[1])) {
                    return 1;
                } else if(Double.parseDouble(o1[1]) == Double.parseDouble(o2[1])) {
                    if(Integer.parseInt(o1[2]) < Integer.parseInt(o2[2])) {
                        return 1;
                    } else if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                        int firstProduct = Integer.parseInt(o1[0].substring(3,o1[0].length()));
                        int lastProduct = Integer.parseInt(o2[0].substring(3,o2[0].length()));

                        if(firstProduct > lastProduct) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            });

            /* 재구매율, 구매횟수 계산 */
            Iterator it = productList.iterator();
            while(it.hasNext()) {
                String product = it.next().toString();
                etc.test04.Example01.UserInfo reUserInfo = rePurchase.get(product);
                etc.test04.Example01.UserInfo userInfo = purchase.get(product);
                float rePurchasePer = (float)reUserInfo.size() / (float)(userInfo.size() == 0 ? reUserInfo.size() : userInfo.size()) * 100;

                String[] item = new String[3];
                item[0] = product;
                item[1] = Float.toString(rePurchasePer);
                item[2] = Integer.toString(userInfo.count + reUserInfo.count);
                pq.add(item);
            }

            /* 우선순위 큐로 가공된 데이터 기준으로 최종 결과 값 출력 */
            String[] answer = productList.size() > 0 ? new String[productList.size()] : new String[1];
            answer[0] = "no result";
            int i = 0;
            while(!pq.isEmpty()) {
                answer[i++] = pq.poll()[0];
            }

            return answer;


        }

        public String doProcess(String record, Map<String, etc.test04.Example01.UserInfo> purchase, Map<String, etc.test04.Example01.UserInfo> rePurchase) {
            String recordArr[] = record.split(" ");
            String user = recordArr[1];
            String product = recordArr[2];

            etc.test04.Example01.UserInfo reUserInfo = rePurchase.get(product);
            reUserInfo = reUserInfo == null ? new etc.test04.Example01.UserInfo() : reUserInfo;
            rePurchase.put(product, reUserInfo);

            if(reUserInfo.get(user) == null) {
                etc.test04.Example01.UserInfo userInfo = purchase.get(product);
                userInfo = userInfo == null ? new etc.test04.Example01.UserInfo() : userInfo;
                purchase.put(product, userInfo);

                if(userInfo.get(user) == null) {
                    userInfo.put(user,"Y");
                    userInfo.count = userInfo.count + 1;

                    purchase.put(product, userInfo);
                } else {
                    reUserInfo.put(user,"Y");
                    reUserInfo.count = reUserInfo.count + 1;

                    rePurchase.put(product, reUserInfo);
                }

            } else {
                reUserInfo.count = reUserInfo.count + 1;
            }
            return product;
        }

        public int convertDateToDay(String date) {

            String dateArr[] = date.split("-");
            int year = Integer.parseInt(dateArr[0]) * (30*12);
            int month = Integer.parseInt(dateArr[1]) * 30;
            int day = Integer.parseInt(dateArr[2]);

            return year + month + day;
        }

        public static void main(String args[]) {

        /*
        String[] records = {
                  "2020-02-02 uid1 pid1"
                , "2020-02-26 uid1 pid1"
                , "2020-02-26 uid2 pid1"
                , "2020-02-27 uid3 pid2"
                , "2020-02-28 uid4 pid2"
                , "2020-02-29 uid3 pid3"
                , "2020-03-01 uid4 pid3"
                , "2020-03-03 uid1 pid1"
                , "2020-03-04 uid2 pid1"
                , "2020-03-05 uid3 pid2"
                , "2020-03-05 uid3 pid3"
                , "2020-03-05 uid3 pid3"
                , "2020-03-06 uid1 pid4"
        };
        int k = 10;
        String date = "2020-03-05";
         */

            String[] records = {

                    "2020-02-03 uid141 pid32"
                    , "2020-02-04 uid32 pid32"
                    , "2020-02-02 uid141 pid141"
                    , "2020-02-05 uid32 pid141"
            };
            int k = 10;
            String date = "2020-02-05";

        /*
        String[] records = {
                "2020-01-01 uid1000 pid5000"
        };
        int k = 10;
        String date = "2020-01-11";
        */

            etc.test04.Example01 example01 = new etc.test04.Example01();
            //example01.solution(records, k, date);

            System.out.println(Arrays.toString(example01.solution(records, k, date)));

        }

}
