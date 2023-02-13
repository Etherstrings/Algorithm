package src.Sword2Job;

/**
 * @author Etherstrings
 * @create 2022-03-08 9:37 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L04 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  9:37 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  09 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 */
public class L04 {
    //方法一：逐行二分法
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                }
            }

            //当前行没有
            //并且下一行的第一个值已经大于目标值
            if (i < m - 1 && matrix[i + 1][0] > target) {
                return false;
            }
        }

        return false;
    }

    //方法二：逐步平铺
    public boolean findNumberIn2DArray1(int[][] matrix, int target){
        //一个规律，如果在矩阵中一个元素大于目标值，则其正下方的元素均大于目标值，
        //此时需要将位置左移，如果当前元素小于目标值，则其正左方元素均小于目标值，需要将位置下移，
        //采用这种先移列排除大值，再移行寻找目标值的方法。

        //从右上角开始
            //逐步搜索

        if(matrix.length==0){
            return false;
        }

        int m=matrix.length;
        int n=matrix[0].length;

        //从矩阵的右上角开始
        int row=0;
        int column=n-1;

        //左移到边，下移到边
        //结束
        while(row<m&&column>=0){
            if(matrix[row][column]>=0){
                return true;

                //如果大了，左移列
            }else if(matrix[row][column]>target){
                column--;

                //如果小了，往下移动行
            }else if(matrix[row][column]<target){
                row++;
            }
        }
        return false;
    }
}
