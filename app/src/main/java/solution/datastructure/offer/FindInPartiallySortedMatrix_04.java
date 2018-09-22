package solution.datastructure.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */
public class FindInPartiallySortedMatrix_04 {

    public static boolean findNum(int[][] arr, int num) {
        if (arr == null && arr.length == 0) return false;
        int rows = arr.length;
        int columns = arr[0].length;
        int row = 0;
        int column = columns - 1;
        while (row <= rows - 1 && column >= 0) {
            if (arr[row][column] > num) column--;
            else if (arr[row][column] < num) row++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 2;
        long start, end;

        start = System.nanoTime();
        System.out.println("num " + num + " is" + (findNum(arr, num) ? "" : " not") + " exist");
        end = System.nanoTime();
        System.out.println("duplicateNumByHashMap use time: " + (end - start));
    }
}
