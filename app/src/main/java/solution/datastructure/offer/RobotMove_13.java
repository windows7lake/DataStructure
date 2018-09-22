package solution.datastructure.offer;

public class RobotMove_13 {

    /**
     * 返回机器人能到达的格子数
     *
     * @param k    阈值
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @return
     */
    public static int movingCount(int k, int rows, int cols) {
        if (k < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        int count = movingCountCore(k, rows, cols, 0, 0, visited);

        return count;
    }

    // 判断从第row行、第col列出发可以到达的格子数
    public static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (checkIn(k, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(k, rows, cols, row, col - 1, visited)
                    + movingCountCore(k, rows, cols, row - 1, col, visited)
                    + movingCountCore(k, rows, cols, row, col + 1, visited)
                    + movingCountCore(k, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    // 检查机器人能否到达该格子
    public static boolean checkIn(int k, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col]
                && getDigitalSum(row) + getDigitalSum(col) <= k)
            return true;
        return false;
    }

    // 求一个数的各位数和
    public static int getDigitalSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum = number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int step = movingCount(0, 1, 1);
        System.out.println("robot move step: " + step);
    }
}
