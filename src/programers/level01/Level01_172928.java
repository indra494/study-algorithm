package programers.level01;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class Level01_172928 {

    public int[] solution(String[] park, String[] routes) {

        String newArr[][] = new String[park.length][];
        int[] startIdx = new int[2];

        for(int i=0; i<park.length; i++) {
            char parkSub[] = park[i].toCharArray();
            String tempArr[] = new String[parkSub.length];
            for(int j=0; j<parkSub.length; j++) {
                if(parkSub[j] == 'S') {
                    startIdx[0] = i;
                    startIdx[1] = j;
                }
                tempArr[j] = Character.toString(parkSub[j]);
            }
            newArr[i] = tempArr;
        }

        for(int i=0; i<routes.length; i++) {
            String move[] = routes[i].split(" ");
            int x = 0;
            int y = 0;
            if(move[0].equals("E")) {
                // +
                y += Integer.parseInt(move[1]);
            } else if(move[0].equals("W")) {
                // -
                y -= Integer.parseInt(move[1]);
            } else if(move[0].equals("N")) {
                // -
                x -= Integer.parseInt(move[1]);
            } else {
                // +
                x += Integer.parseInt(move[1]);
            }

            if(checkMove(newArr, startIdx, x, y)) {
                startIdx[0] += x;
                startIdx[1] += y;
            }

        }

        int[] answer = {startIdx[0],startIdx[1]};
        return answer;
    }

    public boolean checkMove(String[][] targetArr, int[] now, int x, int y) {
        boolean result = true;

        try {
            if(x != 0) {
                for (int i = 1; i <= x; i++) {
                    if (targetArr[now[0] + i][now[1]].equals("X")) return false;
                }
                for (int i = -1; i >= x; i--) {
                    if (targetArr[now[0] + i][now[1]].equals("X")) return false;
                }
            } else if(y != 0) {
                for (int i = 1; i <= y; i++) {
                    if (targetArr[now[0]][now[1] + i].equals("X")) return false;
                }
                for (int i = -1; i >= y; i--) {
                    if (targetArr[now[0]][now[1] + i].equals("X")) return false;
                }
            }
        } catch(Exception e) {
            return false;
        }

        return result;
    }

    public static void main(String args[]) {

        String park[] = {"SOO","OOO","OOO"};
        String routes[] = {"E 2","S 2","W 1"};
        Level01_172928 level01 = new Level01_172928();
        level01.solution(park,routes);


    }

}
