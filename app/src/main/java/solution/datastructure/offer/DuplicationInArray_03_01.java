package solution.datastructure.offer;

import java.util.HashMap;

import solution.datastructure.sort.QuickSort;
import solution.datastructure.sort.Sorter;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复的次数。
 * 请找出数组中任意一个重复的数字。
 * 例如如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3。
 */
public class DuplicationInArray_03_01 {

    public static void duplicateNumBySort(int[] arr) { // 时间复杂度：O(n*log n)  空间复杂度：O(1)
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0 || arr[i] > arr.length)
                throw new RuntimeException("arr values should be between 0 and arr.length");

        Sorter sorter = new QuickSort();
        sorter.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                System.out.print(arr[i++] + ", ");
        }
    }

    public static void duplicateNumByHashMap(int[] arr) { // 时间复杂度：O(n)  空间复杂度：O(n)
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0 || arr[i] > arr.length)
                throw new RuntimeException("arr values should be between 0 and arr.length");

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : arr) {
            hashMap.put(a, (hashMap.get(a) == null ? 0 : hashMap.get(a)) + 1);
        }
        for (int b : hashMap.keySet()) {
            if (hashMap.get(b) > 1)
                System.out.print(b + ", ");
        }
    }

    public static void duplicateNum(int[] arr) { // 时间复杂度：O(n)  空间复杂度：O(1)
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0 || arr[i] >= arr.length)
                throw new RuntimeException("arr values should be between 0 and arr.length");

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[arr[i]] == arr[i]) {
                    System.out.print(arr[i] + ", ");
                    break;
                }
                int tmp = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = tmp;
//                int tmp = arr[arr[i]];
//                arr[arr[i]] = arr[i];
//                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 3, 5, 2};
        long start, end;

        start = System.nanoTime();
        duplicateNumBySort(arr);
        end = System.nanoTime();
        System.out.println("duplicateNumBySort use time: " + (end - start));

        arr = new int[]{2, 3, 1, 0, 3, 5, 2};
        start = System.nanoTime();
        duplicateNumByHashMap(arr);
        end = System.nanoTime();
        System.out.println("duplicateNumByHashMap use time: " + (end - start));

        arr = new int[]{2, 3, 1, 0, 3, 5, 2};
        start = System.nanoTime();
        duplicateNum(arr);
        end = System.nanoTime();
        System.out.println("duplicateNum use time: " + (end - start));
    }
}
