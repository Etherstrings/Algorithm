package DP;

/**
 * @author Etherstrings
 * @create 2023-03-03 14:53 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L198 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/3 - the current system date.  14:53 - the current system time.  2023 - the current year.  03 - the current month.  03 - the current day of the month.  14 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L198 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0||nums==null){
            return 0;
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[][] dp=new int[nums.length][2];
        //0偷
        //1不偷
        dp[0][0]=nums[0];
        dp[0][1]=0;
        dp[1][0]=nums[1];
        dp[1][1]=Math.max(dp[0][1],dp[0][0]);
        int ans=0;
        for(int i=2;i<nums.length;i++){
            //当前偷 上一个就不能偷
            dp[i][0]=Math.max(Math.max(dp[i-2][0],dp[i-2][1])+nums[i],dp[i-1][1]+nums[i]);
            //当前不偷 上一个可以偷
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
            ans=Math.max(Math.max(dp[i][0],dp[i][1]),ans);
        }
        return ans;
    }
}
