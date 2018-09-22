package solution.datastructure.offer;

public class MinNumberInRotatedArray_11 {

    public static int minNumber(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        int start = 0;
        int end = arr.length - 1;
        int middle = start;

        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                middle = end;
                break;
            }

            middle = (start + end) / 2;
            if (arr[start] == arr[end] && arr[start] == arr[middle])
                return minInOrder(arr, start, end);

            if (arr[middle] >= arr[start]) start = middle;
            else if (arr[middle] <= arr[end]) end = middle;
        }

        return arr[middle];
    }

    public static int minInOrder(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start + 1; i <= end; ++i) {
            if (result > arr[i]) result = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9};
        int[] arr1 = {1, 0, 1, 1, 1, 1};
        System.out.println(minNumber(arr1));
    }
}
