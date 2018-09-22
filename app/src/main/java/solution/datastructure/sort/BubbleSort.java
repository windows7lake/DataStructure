package solution.datastructure.sort;

/**
 * 冒泡排序 == 稳定排序
 * 时间复杂度:  最好: O(n)，最坏: O(n^2)
 * 空间复杂度： O(1)
 */
public class BubbleSort extends Sorter {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }
}
