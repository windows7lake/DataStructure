package solution.datastructure.sort;

/**
 * 归并排序 == 稳定排序
 * 时间复杂度:  平均时间复杂度：O(N*logN)
 * 空间复杂度： O(n)
 */
public class MergeSort extends Sorter {

    public void separateTwoPart(int[] arr, int[] tmp, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        separateTwoPart(arr, tmp, low, mid);
        separateTwoPart(arr, tmp, mid + 1, high);
        merge(arr, tmp, low, mid, high);
    }

    public void merge(int[] arr, int[] tmp, int low, int mid, int high) {
        int i, j, k;
        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j]) tmp[k] = arr[i++];
            else tmp[k] = arr[j++];
        }

        for (; i <= mid; i++, k++)
            tmp[k] = arr[i];

        for (; j <= high; j++, k++)
            tmp[k] = arr[j];

        for (k = low; k <= high; k++)
            arr[k] = tmp[k];
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");
        int[] tmp = new int[arr.length];
        separateTwoPart(arr, tmp, 0, arr.length - 1);
    }
}