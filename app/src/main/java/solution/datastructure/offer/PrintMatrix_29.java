package solution.datastructure.offer;

public class PrintMatrix_29 {

    public static void printMatrix(int[][] arr) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) return;
        int start = 0;
        while (start * 2 < arr.length && start * 2 < arr[0].length) {
            printMatrix(arr, arr[0].length, arr.length, start++);
        }
    }

    public static void printMatrix(int[][] arr, int cols, int rows, int start) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;

        for (int i = start; i <= endX; i++)
            System.out.print(arr[start][i] + ", ");

        if (start < endY)
            for (int i = start + 1; i <= endY - 1; i++)
                System.out.print(arr[i][endX] + ", ");

        if (start < endY)
            for (int i = endX; i >= start; i--)
                System.out.print(arr[endY][i] + ", ");

        if (start < endX)
            for (int i = endY - 1; i >= start + 1; i--)
                System.out.print(arr[i][start] + ", ");
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] arr1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} /*,{13, 14, 15, 16}*/};
        int[][] arr2 = {{1, 2, 3, 4}};
        int[][] arr3 = {{1}, {2}, {3}, {4}};
        int[][] arr4 = {{1, 2}};
        int[][] arr5 = {{1}, {2}};
        int[][] arr6 = {{1}};
        int[][] arr7 = {{1}, {2}, {3}};
        int[][] arr8 = null;
        int[][][] sample = {arr, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
        for (int i = 0; i < 8; i++) {
            printMatrix(sample[i]);
            System.out.println();
        }
    }
}
