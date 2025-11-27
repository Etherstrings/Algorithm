package DP;

/**
 * @author Etherstrings
 * @create 2023-03-08 16:30 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S47 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/8 - the current system date.  16:30 - the current system time.  2023 - the current year.  03 - the current month.  08 - the current day of the month.  16 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class S47 {
    public int maxValue(int[][] grid) {
        int level=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[level][col];
        dp[0][0]=grid[0][0];
        for(int i=1;i<level;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<level;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[level-1][col-1];
    }
}
