package src.DP;

/**
 * @author Etherstrings
 * @create 2022-08-10 23:27 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L152 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/10 - the current system date.  23:27 - the current system time.  2022 - the current year.  08 - the current month.  10 - the current day of the month.  23 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L152 {
    //152. 乘积最大子数组
    //给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    //
    //测试用例的答案是一个 32-位 整数。
    //
    //子数组 是数组的连续子序列。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [2,3,-2,4]
    //输出: 6
    //解释: 子数组 [2,3] 有最大乘积 6。
    //示例 2:
    //
    //输入: nums = [-2,0,-1]
    //输出: 0
    //解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
    public int maxProduct(int[] nums){
        //当前i位置
        //所拥有的连续乘积最大值+最小值
        int[][] dp=new int[nums.length][2];

        //初始化
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];

        //递推公式
        //遇到负数---最大变最小---最小变最大
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                dp[i][0]=dp[i-1][1]*nums[i];
                dp[i][1]=Math.min(dp[i-1][0]*nums[i],nums[i]);
            }else {
                dp[i][0]=Math.max(dp[i-1][0]*nums[i],nums[i]);
                dp[i][1]=Math.min(dp[i-1][1]*nums[i],nums[i]);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int[] a:dp){
            max=Math.max(a[0],max);
        }
        return max;
    }
}
