package example.test01;

import java.util.Stack;

public class Example01 {

    class Transprop {
        int to = 0;
        int from = 0;
        int balance = 0;
    }

    class Transtruct {

        int initBalance = 0;
        int balance = 0;
        int number = 0;

        Stack<Transprop> from = new Stack<>();
        Stack<Transprop> to = new Stack<>();
    }

    public int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
        int[] answer = new int[balance.length];

        Transtruct tstruct[] = new Transtruct[balance.length];
        for(int i=0; i<balance.length; i++) {
            tstruct[i] = new Transtruct();
            tstruct[i].initBalance = balance[i];
            tstruct[i].balance = balance[i];
            tstruct[i].number = i+1;

            Transprop prop = new Transprop();
            prop.balance = balance[i];
            prop.to = (i+1);
            prop.from = (i+1);
            tstruct[i].to.add(prop);
        }

        for(int i=0; i<transaction.length; i++) {
            int single[] = transaction[i];

            int from = single[0];
            int to = single[1];
            int point = single[2];

            // from 처리
            Transprop prop = new Transprop();
            prop.to = to;
            prop.from = from;
            prop.balance = point;

            tstruct[from-1].balance = tstruct[from-1].balance - point;
            tstruct[from-1].from.add(prop);

            // to 처리
            tstruct[to-1].balance = tstruct[to-1].balance + point;
            while(true) {
                Transprop tempProp = tstruct[from-1].to.pop();

                int tempPoint = tempProp.balance - point;
                if(tempPoint > 0) {
                    // 금액이 남았을 경우 from에 남음 금액 다시 push
                    tempProp.balance = tempPoint;
                    tstruct[from-1].to.add(tempProp);

                    // 포인트 만큼 to에 push
                    Transprop insertProp = new Transprop();
                    insertProp.to = tempProp.to;
                    insertProp.from = tempProp.from;
                    insertProp.balance = point;
                    tstruct[to-1].to.add(insertProp);

                    //System.out.println("####11 from :: " + from + ", to :: " + to + " , 옮길금액 :: " + point + " , from 전체돈 :: " + tstruct[from-1].balance + " , to 전체돈 :: " + tstruct[to-1].balance +
                    //        " ,  balance :: " + insertProp.balance + " ,, tempPoint:: " + tempPoint + " , :: originFrom :: " + insertProp.from + " , :: oringinTo :: " + insertProp.to);

                    break;
                } else if(tempPoint <= 0) {
                    // 금액이 부족할경우 (다음 루프 처리를 위해 point 값을 계산)
                    tstruct[to-1].to.add(tempProp);
                    point = point - tempProp.balance;
                    //System.out.println("####22 from :: " + from + ", to :: " + to + " , 옮길금액 :: " + point + " , from 전체돈 :: " + tstruct[from-1].balance + " , to 전체돈 :: " + tstruct[to-1].balance +
                    //        " , balance :: " + tempProp.balance + " , point :: " + point + " , :: originFrom :: " + tempProp.from + " , :: oringinTo :: " + tempProp.to);

                    if(tempPoint == 0) break;
                }
            }
        }

        /*
        System.out.println("=============================================");
        for(int i=0; i<tstruct.length; i++) {

            System.out.println(" ## number :: " + tstruct[i].number);
            System.out.println(" ## tot balance :: " + tstruct[i].balance);

            while(!tstruct[i].to.isEmpty()) {
                Transprop temp = tstruct[i].to.pop();
                System.out.println("---> to data start");
                System.out.println(" ## pop from :: " + temp.from);
                System.out.println(" ## pop to :: " + temp.to);
                System.out.println(" ## pop balance :: " + temp.balance);
                System.out.println("---> to data end");
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("=============================================");
        System.out.println("");
        System.out.println("");
        */

        for(int i=0; i<tstruct.length; i++) {

            for(int j=0; j<abnormal.length; j++) {
                int ab = abnormal[j];

                Stack<Transprop> tempStack = new Stack<>();
                int totScore = 0;
                while(!tstruct[i].to.isEmpty()) {
                    Transprop prop = tstruct[i].to.pop();

                    if(prop.to == ab) {
                        totScore += prop.balance;
                    } else {
                        tempStack.push(prop);
                    }
                }

                tstruct[i].to = tempStack;
                tstruct[i].balance = tstruct[i].balance - totScore;
            }
        }

        for(int i=0; i<tstruct.length; i++) {
            answer[i] = tstruct[i].balance < 0 ? 0 : tstruct[i].balance;
            System.out.print(tstruct[i].balance + ",");
        }

        return answer;
    }

    public static void main(String args[]) {

        // [30, 30, 30, 30], [[1, 2, 10], [2, 3, 20], [3, 4, 5], [3, 4, 30]], [1]           -> [0,20,15,55]
        // [30, 30, 30, 30], [[1, 2, 10], [2, 3, 20], [3, 4, 5], [3, 4, 30]], [2, 3]        -> [20,0,0,40]
        // [40,30,50], [[1,3,20],[2,1,10], [3,1,45],[2,3,10],[1,3,35],[2,1,5], [3,1,10], [3,2,5]], [2]  -> [40,5,45]
        // [100,1,1,1,1], [[1,2,100],[2,3,101], [3,4,102],[4,5,103],[5,1,104]], [1]         - [4,0,0,0]

        int[] balance = {40,30,50};
        int[][] transaction = {
                {1,3,20},
                {2,1,10},
                {3,1,45},
                {2,3,10},
                {1,3,35},
                {2,1,5},
                {3,1,10},
                {3,2,5}
        };
        int[] abnormal = {2};

        Example01 example01 = new Example01();
        example01.solution(balance, transaction, abnormal);

    }


}