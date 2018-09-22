package solution.datastructure.offer;

/**
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 */
public class DuplicationInArray_03_02 {

    public static void duplicateNumWithArray(int[] arr) { // 时间复杂度：O(n)  空间复杂度：O(n)
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 1 || arr[i] >= arr.length)
                throw new RuntimeException("arr values should be between 0 and arr.length");

        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tmp[arr[i]]) {
                System.out.print(arr[i] + ", ");
            }
            tmp[arr[i]] = arr[i];
        }
    }

    public static int duplicateNum(int[] arr) { // 时间复杂度：O(n*log n)  空间复杂度：O(1)
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 1 || arr[i] >= arr.length)
                throw new RuntimeException("arr values should be between 0 and arr.length");

        int start = 1;
        int end = arr.length - 1;
        int mid = 0;
        int count = 0;
        while (start <= end) {
            if (start == end) {
                count = countRange(arr, start, end);
                if (count > 1) {
                    System.out.print(start + ", ");
                }
                break;
            }
            mid = (start + end) / 2;
            count = countRange(arr, start, mid);
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        long start, end;

        start = System.nanoTime();
        duplicateNumWithArray(arr);
        end = System.nanoTime();
        System.out.println("duplicateNumWithArray use time: " + (end - start));

        arr = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        start = System.nanoTime();
        duplicateNum(arr);
        end = System.nanoTime();
        System.out.println("duplicateNum use time: " + (end - start));
    }
}
