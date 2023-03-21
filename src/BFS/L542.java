package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-03-01 22:21 BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L542 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/1 - the current system date.  22:21 - the current system time.  2023 - the current year.  03 - the current month.  01 - the current day of the month.  22 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L542 {
    //542. 01 矩阵
    //给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
    //
    //两个相邻元素间的距离为 1 。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
    //输出：[[0,0,0],[0,1,0],[0,0,0]]
    //示例 2：
    //
    //
    //
    //输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
    //输出：[[0,0,0],[0,1,0],[1,2,1]]
    public int[][] updateMatrix(int[][] mat) {
        //思路2
        //简化1+2
        //不对每一个格子进行BFS
        //而是先进行判断再分析
        //不是从当前位置出发找最小的距离到0
        //而是寻找从0出发，到当前位置的距离
        return getdistence(mat);
    }
    private static int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int[][] getdistence(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 搜索上下左右四个方向
            for (int[] v : vector) {
                int r = s[0] + v[0], c = s[1] + v[1];
                if (r >= 0 && r < row
                        && c >= 0 && c < col
                        && matrix[r][c] > matrix[s[0]][s[1]] + 1) {
                    //这里的意思是，从0到我这需要多少个
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }
}
