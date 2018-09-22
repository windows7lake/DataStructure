package solution.datastructure.sort;

/**
 * 快速排序 == 不稳定排序
 * 时间复杂度:  平均时间复杂度：O(N*logN)
 * 空间复杂度： O(logN)
 */
public class QuickSort extends Sorter {

    public int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) --high;
            arr[low] = arr[high];

            while (low < high && arr[low] <= key) ++low;
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    public void separateTwoPart(int[] arr, int low, int high) {
        if (low >= high) return;
        int pos = partition(arr, low, high);
        separateTwoPart(arr, low, pos - 1);
        separateTwoPart(arr, pos + 1, high);
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");
        separateTwoPart(arr, 0, arr.length - 1);
    }
}
