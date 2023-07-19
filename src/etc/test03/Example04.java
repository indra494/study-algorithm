package etc.test03;

/**
 * n =6, return 12
 */
public class Example04 {

    public int solution(int n) {
        int answer = 0;

        int[] dragonEgg = {1, 0};
        int[] dragon = {0, 0, 0, 0};
        int dragonLengthLastIndex = dragon.length-2;

        int newDragonEgg;
        int newDragon;
        for (int i=0; i<n; i++) {
            newDragonEgg = 0;

            newDragon = dragonEgg[1];
            newDragonEgg += newDragon;
            dragonEgg[1] = dragonEgg[0];

            answer += dragon[3];
            for (int j=dragonLengthLastIndex; j>-1; j--) {
                newDragonEgg += dragon[j];
                dragon[j+1] = dragon[j];
            }
            dragon[0] = newDragon;
            dragonEgg[0] = newDragonEgg;
        }
        for (int i=0; i<dragonEgg.length; i++) {
            answer += dragonEgg[i];
        }
        for (int i=0; i<dragon.length; i++) {
            answer += dragon[i];
        }
        return answer;
    }

    public static void main(String args[]) {

        Example04 example04 = new Example04();
        example04.solution(6);

    }


}
