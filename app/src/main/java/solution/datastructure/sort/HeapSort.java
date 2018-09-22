package solution.datastructure.sort;

/**
 * 堆排序 == 不稳定排序
 * 时间复杂度:  平均时间复杂度：O(N*logN)
 * 空间复杂度： O(1)
 */
public class HeapSort extends Sorter {

    public void biggestHeap(int[] arr, int low, int high) {
        int cur, left;
        for (cur = low, left = 2 * low + 1; left <= high; left = 2 * left + 1) {
            if (left < high && arr[left] < arr[left + 1]) left++;
            if (arr[cur] >= arr[left]) break;
            swap(arr, cur, left);
            cur = left;
        }
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = arr.length / 2 - 1; i >= 0; i--)
            biggestHeap(arr, i, arr.length - 1);

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            biggestHeap(arr, 0, j - 1);
        }
    }
}
