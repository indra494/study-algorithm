package example.sort;

public class QuickSortExample01 {

    public int[] quickSort(int[] arr) {
        int pivot = 0;
        int left = pivot+1;
        int right = arr.length;

        while(left < right) {


        }


        return new int[]{};
    }


    /* 퀵정렬 */
    public static void main(String args[]) {
        int[] arr = {5,7,9,0,3,1,6,2,4,8};
        QuickSortExample01 quickSortExample01 = new QuickSortExample01();
        quickSortExample01.quickSort(arr);
    }

}
