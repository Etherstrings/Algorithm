package ToBigFactory.DP;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-07-30 14:25 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L674 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  14:25 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  14 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L674 {

    public int findLengthOfLCIS(int[] nums) {
        //dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
                ans=Math.max(dp[i],ans);
            }
        }
        return ans;
    }
}
