package solution.datastructure.sort;

import java.util.Random;

public class QuickSort2 {


    public static void main(String[] args) {
        int[] arr7 = new int[]{6, 3, 7, 2, 9, 3, 5, 1};
        quickSort(arr7, 0, arr7.length - 1);
//        for (int a : arr7)
//            System.out.print(a + ", ");
    }

    public static int partition2(int[] arr, int low, int high) {
        if (low < 0 || high >= arr.length)
            throw new RuntimeException("Invalid Parameters");
        Random random = new Random();
        int index = random.nextInt(high - low) + low;
        System.out.println("index: " + index);
        swap(arr, index, high);

        int small = low - 1;
        for (index = low; index < high; ++index) {
            System.out.print("index: " + index);
            if (arr[index] < arr[high]) {
                ++small;
                if (small != index)
                    swap(arr, index, small);
            }
            System.out.println("  ===  small: " + small);
            for (int a : arr)
                System.out.print(a + ", ");
            System.out.println("");
        }

        ++small;
        swap(arr, small, high);

        return small;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int index = partition2(arr, low, high);
//        if (index > low) quickSort(arr, low, index - 1);
//        if (index < high) quickSort(arr, index + 1, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
