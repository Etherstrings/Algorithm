package WorkReview.CralBook.ArraysView.MoNi;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-18
 */
public class L59BuildMatrixII {
    //给你一个正整数 n ，生成一个包含 1 到 n*n 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    //输入：n = 3
    //输出：[[1,2,3],[8,9,4],[7,6,5]]
    //示例 2：
    //
    //输入：n = 1
    //输出：[[1]]
    //提示：
    //
    //1 <= n <= 20


    /**
     * 一定要注意每次填充 [) 左闭右开
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int round = (n + 1) / 2;
        int num = 1;
        for (int i = 0; i < round; i++) {
            for (int j = i; j<n-1-i;j++) {
                matrix[i][j] = num++;
            }
            for (int j = i; j<n-1-i;j++) {
                matrix[j][n-1-i] = num++;
            }
            for (int j= n-1-i; j>i;j--) {
                matrix[n-1-i][j] = num++;
            }
            for (int j= n-1-i; j>i;j--) {
                matrix[j][i] = num++;
            }
        }
        if (n % 2 == 1) {
            matrix[n/2][n/2] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

