package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-30 15:22 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L53 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  15:22 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  15 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L53 {
    public static void main(String[] args) {

    }
    //最大子序列和
    public int maxSubArray(int[] nums) {

        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        int ans=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
