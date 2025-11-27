import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-20 21:25 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1260 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/20 - the current system date.  21:25 - the current system time.  2022 - the current year.  07 - the current month.  20 - the current day of the month.  21 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1260 {
    //1260. 二维网格迁移
    //给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
    //
    //每次「迁移」操作将会引发下述活动：
    //
    //位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    //位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    //位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    //请你返回 k 次迁移操作后最终得到的 二维网格。
    //
    //
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ret.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }
        return ret;
    }

}
