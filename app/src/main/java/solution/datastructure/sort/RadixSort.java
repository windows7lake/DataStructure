package solution.datastructure.sort;

public class RadixSort extends Sorter {

    private static int getNumOfDigital(int[] arr) {
        int largest = 0, num = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > largest) largest = arr[i];
        while (largest > 0) {
            largest /= 10;
            num++;
        }
        return num;
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("arr should not be null");

        int k = 0, n = 1;
        int[][] temp = new int[10][arr.length];
        int[] order = new int[10];
        int num = getNumOfDigital(arr);
        while (num > 0) {
            for (int i = 0; i < arr.length; i++) {
                int lsd = (arr[i] / n) % 10;
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++)
                        arr[k++] = temp[i][j];
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            num--;
        }
    }
}
