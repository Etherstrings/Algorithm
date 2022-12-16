package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-26 20:10 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII10 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/26 - the current system date.  20:10 - the current system time.  2022 - the current year.  07 - the current month.  26 - the current day of the month.  20 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class SII10 {
    //
    public int numWays(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
