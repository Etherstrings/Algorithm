package SecondTime.DP;

/**
 * @author Etherstrings
 * @create 2022-08-29 17:02 SecondTime.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L62 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  17:02 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  17 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L62 {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
