package etc.test00;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		TestMain test = new TestMain();
		test.test3();
	}

    private boolean existEmptyPlacePoint(int x, int y) {
        for (List<List<Integer>> tempEmptyPlacePointGroup : emptyPlacePointGroupList) {
            for (List<Integer> tempEmptyPlacePoint : tempEmptyPlacePointGroup) {
                if ((x == tempEmptyPlacePoint.get(0))
                        && (y == tempEmptyPlacePoint.get(1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkDetailEmptyPlacePoint(List<List<Integer>> emptyPlacePointGroup, int x, int y) {
        if (tempReadLineString[y].charAt(x) == EMPTY_VALUE) {
            if (existEmptyPlacePoint(x, y)) {
                return ;
            }

            List<Integer> emptyPlacePoint = new ArrayList<>();
            emptyPlacePoint.add(x);
            emptyPlacePoint.add(y);
            emptyPlacePointGroup.add(emptyPlacePoint);

            checkEmptyPlacePoint(emptyPlacePointGroup, x, y);
        }
    }

    private void checkEmptyPlacePoint(List<List<Integer>> emptyPlacePointGroup, int x, int y) {
        if (x >= maxX || x < 0 || y >= maxY || y< 0) {
            return ;
        }
        if ((x+1) < maxX)
        	checkDetailEmptyPlacePoint(emptyPlacePointGroup, x+1, y);
        if ((x-1) >= 0)
        	checkDetailEmptyPlacePoint(emptyPlacePointGroup, x-1, y);
        if ((y+1) < maxY)
        	checkDetailEmptyPlacePoint(emptyPlacePointGroup, x, y+1);
        if ((y-1) >= 0)
        	checkDetailEmptyPlacePoint(emptyPlacePointGroup, x, y-1);
    }


    private static final char EMPTY_VALUE = '0';
    private int maxX;
    private int maxY;
    private String[] tempReadLineString;
    private List<List<List<Integer>>> emptyPlacePointGroupList = new ArrayList<>();;

    private void test3() {
        emptyPlacePointGroupList = new ArrayList<>();
        String inputValue = "6 6";
        tempReadLineString = new String[]{
                "000000",
                "111111",
                "000000",
                "111111",
                "000000",
                "000000"};

        String[] inputValues = inputValue.split(" ");
        maxY = Integer.valueOf(inputValues[0]);
        maxX = Integer.valueOf(inputValues[1]);

        //todo temp line info
        boolean isPass = false;
        List<List<Integer>> emptyPlacePointGroup;
        List<Integer> emptyPlacePoint;

        boolean isAdd;
        for (int k=0; k<maxX; k++) {
            String readString = tempReadLineString[k];
            for (int i=0; i<maxY; i++) {
                if (readString.charAt(i) == EMPTY_VALUE) {
                    if (emptyPlacePointGroupList.size() <= 0) {
                        emptyPlacePointGroup = new ArrayList<>();
                        emptyPlacePoint = new ArrayList<>();
                        emptyPlacePoint.add(i);
                        emptyPlacePoint.add(k);
                        emptyPlacePointGroup.add(emptyPlacePoint);
                        emptyPlacePointGroupList.add(emptyPlacePointGroup);

                        checkEmptyPlacePoint(emptyPlacePointGroup, i, k);
                    } else {
                        if ( ! existEmptyPlacePoint(i, k)) {
                            emptyPlacePointGroup = new ArrayList<>();
                            emptyPlacePoint = new ArrayList<>();
                            emptyPlacePoint.add(i);
                            emptyPlacePoint.add(k);
                            emptyPlacePointGroup.add(emptyPlacePoint);
                            emptyPlacePointGroupList.add(emptyPlacePointGroup);

                            checkEmptyPlacePoint(emptyPlacePointGroup, i, k);
                        }
                    }
                }
            }
        }

        System.out.println("count : " + emptyPlacePointGroupList.size());
    }
}
 