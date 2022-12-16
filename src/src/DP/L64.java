package src.DP;

/**
 * @author Etherstrings
 * @create 2022-08-10 23:04 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L64 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/10 - the current system date.  23:04 - the current system time.  2022 - the current year.  08 - the current month.  10 - the current day of the month.  23 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L64 {
    //64. 最小路径和
    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    //输出：7
    //解释：因为路径 1→3→1→1→1 的总和最小。
    //示例 2：
    //
    //输入：grid = [[1,2,3],[4,5,6]]
    //输出：12
    public int minPathSum(int[][] grid) {
        //当前路径的最小数字
        int[][] dp=new int[grid.length][grid[0].length];

        //初始化位置
        dp[0][0]=grid[0][0];

        for(int i=1;i<grid[0].length;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }

        for(int i=1;i<grid.length;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        //递推公式
        //只能从左或者从右移动---选更小的路径移动
        //dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
