package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-29 19:48 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L198_Thielf_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  19:48 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  19 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L198_Thielf_1 {
    public int rob(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][2];
        //0偷
        //1不偷
        dp[0][0]=nums[0];
        dp[0][1]=0;
        for(int i=1;i<nums.length;i++){
            dp[i][0]=dp[i-1][1]+nums[i];
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
