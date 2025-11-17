/**
 * @author Justice_wby
 * @create 2023-01-26 16:34
 */
public class L74 {
    //74. 搜索二维矩阵
    //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    //
    //每行中的整数从左到右按升序排列。
    //每行的第一个整数大于前一行的最后一个整数。
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
