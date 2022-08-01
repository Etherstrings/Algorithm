package DP;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-08-02 0:26 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L53_Max_ChildernString - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/2 - the current system date.  0:26 - the current system time.  2022 - the current year.  08 - the current month.  02 - the current day of the month.  00 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L53_Max_ChildernString {
    //53. 最大子数组和
    //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //子数组 是数组中的一个连续部分。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    //输出：6
    //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    //示例 2：
    //
    //输入：nums = [1]
    //输出：1
    //示例 3：
    //
    //输入：nums = [5,4,-1,7,8]
    //输出：23
    //
    //
    //提示：
    //
    //1 <= nums.length <= 105
    //-104 <= nums[i] <= 104
    public int maxSubArray(int[] nums){
        if(nums.length==1&&nums[0]==-1){
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]：包括下标i之前的最大连续子序列和为dp[i]。
        int[] dp=new int[nums.length];
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }

        int res=nums[0];
        for(int i=0;i< dp.length;i++){
            res=Math.max(dp[i],res);
        }
        return res;
    }

}
