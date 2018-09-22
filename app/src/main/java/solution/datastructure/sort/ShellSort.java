package solution.datastructure.sort;

/**
 * 希尔排序 == 稳定排序
 * 时间复杂度:  希尔增量时间复杂度为O(n²)，
 *              Hibbard增量的希尔排序的时间复杂度为O(n^(3/2))，
 *              希尔排序时间复杂度的下界是n*log2n
 * 空间复杂度： O(1)
 */
public class ShellSort extends Sorter {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int k = arr.length / 2; k > 0; k /= 2)
            for (int i = k; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                for (; j >= k && tmp < arr[j - k]; j -= k)
                    arr[j] = arr[j - k];
                arr[j] = tmp;
            }
    }
}
