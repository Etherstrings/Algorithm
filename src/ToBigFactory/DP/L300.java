package ToBigFactory.DP;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-07-30 13:31 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L300 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  13:31 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  13 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L300 {

    //300. 最长递增子序列
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    //
    //
    //示例 1：
    //
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    //示例 2：
    //
    //输入：nums = [0,1,0,3,2,3]
    //输出：4
    //示例 3：
    //
    //输入：nums = [7,7,7,7,7,7,7]
    //输出：1
    public int lengthOfLIS(int[] nums) {
        //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int now=nums[i];
                if(now>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ans=-1;
        for(int n:dp){
            ans=Math.max(n,ans);
        }
        return ans;
    }
}
