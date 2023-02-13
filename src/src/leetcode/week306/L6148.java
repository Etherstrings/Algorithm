package src.leetcode.week306;

/**
 * @author Etherstrings
 * @create 2022-08-14 10:30 leetcode.week306 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6148 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  10:30 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  10 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6148 {
    //给你一个大小为 n x n 的整数矩阵 grid 。
    //
    //生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
    //
    //maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
    //换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
    //
    //返回生成的矩阵。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
    //输出：[[9,9],[8,6]]
    //解释：原矩阵和生成的矩阵如上图所示。
    //注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
    //示例 2：
    //
    //
    //
    //输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
    //输出：[[2,2,2],[2,2,2],[2,2,2]]
    //解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
    public int[][] largestLocal(int[][] grid) {
        int level=grid.length;

        int[][] ans=new int[level-2][level-2];

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=getMax(grid,i,j);
            }
        }
        return ans;
    }

    int getMax(int[][] grid,int i,int j){
        int max=-1;
        for(int level=i;level<i+3;level++){
            for(int col=j;col<j+3;col++){
                max=Math.max(max,grid[level][col]);
            }
        }
        return max;
    }
}
