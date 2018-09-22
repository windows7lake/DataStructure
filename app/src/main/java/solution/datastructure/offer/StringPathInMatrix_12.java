package solution.datastructure.offer;

public class StringPathInMatrix_12 {

    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param search 待搜索的字符串
     * @return true 存在路径, false 不存在路径
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] search) {
        if (matrix == null || matrix.length == 0 || rows < 1 || cols < 1
                || matrix.length != rows * cols || search == null || search.length == 0)
            return false;

        // 初始化访问标记矩阵
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        // 以每个点为起始点进行搜索
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (hasPathCore(matrix, rows, cols, search, 0, row, col, visited))
                    return true;

        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix  输入矩阵
     * @param rows    矩阵行数
     * @param cols    矩阵列数
     * @param search  待搜索的字符串
     * @param index   已经处理str中字符个数
     * @param row     当前处理的行数
     * @param col     当前处理的列数
     * @param visited 访问标记数组
     * @return true 存在路径， false 不存在路径
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] search,
                                       int index, int row, int col, boolean[] visited) {
        if (index >= search.length) return true;

        boolean hasPath = false;
        // 推断位置是否合法
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == search[index] && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            index++;

            // 按左上右下进行探索
            hasPath = hasPathCore(matrix, rows, cols, search, index, row, col - 1, visited)
                    || hasPathCore(matrix, rows, cols, search, index, row - 1, col, visited)
                    || hasPathCore(matrix, rows, cols, search, index, row, col + 1, visited)
                    || hasPathCore(matrix, rows, cols, search, index, row + 1, col, visited);

            // 回溯
            if (!hasPath) {
                visited[row * cols + col] = false;
                --index;
            }
        }
        return hasPath;
    }


    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] search = "ABCCEE".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, search));
    }
}
