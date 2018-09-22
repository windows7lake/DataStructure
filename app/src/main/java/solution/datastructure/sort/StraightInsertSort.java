package solution.datastructure.sort;

/**
 * 直接插入排序 == 稳定排序
 * 时间复杂度:  当待排数组有序时，没有移动操作，此时复杂度为O(N)
 *              当待排数组是逆序时，比较次数达到最大，时间复杂度为O(N^2)
 * 空间复杂度： O(1)
 */
public class StraightInsertSort extends Sorter {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = tmp;
        }
    }
}
