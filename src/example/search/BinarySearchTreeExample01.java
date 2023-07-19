package example.search;

public class BinarySearchTreeExample01 {
    /* 이진탐색 */

    public void search(int arr[], int start, int mid, int end, int findValue) {
        if(arr[mid] == findValue) {
            System.out.println(" find value idx :: " + mid);
            return;
        } else if(arr[mid] > findValue) {
            end = mid -1;
            mid = start + ((end-start)/2);
        } else {
            start = mid +1; // 2   3 - 2
            mid = start + ((end-start)/2);
        }

        System.out.println(" start :: " + start + ", mid :: " + mid + ", end :: " + end);

        search(arr,start,mid,end,findValue);
    }

    public static void main(String args[]) {
        int[] arr = {0,2,4,6,8,10,12,14,16,18};

        int start = 0;
        int mid = (arr.length-1) / 2;
        int end = arr.length-1;

        BinarySearchTreeExample01 binarySearchTreeExample01 = new BinarySearchTreeExample01();
        binarySearchTreeExample01.search(arr,start,mid,end,8);

    }
}
