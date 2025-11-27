package DP;

/**
 * @author Etherstrings
 * @create 2022-07-26 19:45 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L416 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/26 - the current system date.  19:45 - the current system time.  2022 - the current year.  07 - the current month.  26 - the current day of the month.  19 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L416 {
    //416. 分割等和子集
    //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,5,11,5]
    //输出：true
    //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    //示例 2：
    //
    //输入：nums = [1,2,3,5]
    //输出：false
    //解释：数组不能分割成两个元素和相等的子集。
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        if(nums.length==1){
            return false;
        }
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        //DP数组表示什么？
        int[] dp=new int[target+1];

        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return target==dp[target];
     }
}
