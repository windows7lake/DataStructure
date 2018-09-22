package solution.datastructure.sort;

public class Test {

    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(random.nextInt(500) + 1 + ", ");
//        }
        int[] arr = new int[]{43, 333, 102, 264, 359, 140, 238, 57, 39, 326};
        int[] arr1 = new int[]{43, 333, -1, 264, 4, 140, 238, -490, 39, 326};
        int[] arr2 = new int[]{43, 333, 102, -682822435, 359, 140, 238, 57, 39, 326};
        int[] arr3 = new int[]{43, 333, 102, 264, 969683458, 140, 238, 57, 39, 326};
        int[] arr4 = new int[]{43, 359, 0, 264, 359, 1, -238, 57, -238, -1};
        int[] arr5 = new int[]{0};
        int[] arr6 = new int[]{};
        int[] arr7 = new int[]{6, 3, 7, 2, 9, 3, 5, 1};
        int[][] tmp = new int[][]{arr, arr1, arr2, arr3, arr4, arr5, arr6};
        Sorter sorter = new QuickSort();
        for (int i = 0; i < tmp.length; i++) {
            sorter.sort(tmp[i]);
            for (int a : tmp[i])
                System.out.print(a + ", ");
            System.out.println("");
        }
    }
}
