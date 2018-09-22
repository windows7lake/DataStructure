package solution.datastructure.offer;

public class ReorderArray_21 {

    public static void reorderArray(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && (arr[begin] & 1) == 1)
                begin++;
            while (begin < end && (arr[end] & 1) == 0)
                end--;
            if (begin < end) {
                int tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reorderArray(arr);
        for (int a : arr)
            System.out.print(a + ", ");
    }
}
