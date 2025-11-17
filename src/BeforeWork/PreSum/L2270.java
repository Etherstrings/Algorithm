package PreSum;

/**
 * @author Etherstrings
 * @create 2023-02-28 15:01 PreSum - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2270 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/28 - the current system date.  15:01 - the current system time.  2023 - the current year.  02 - the current month.  28 - the current day of the month.  15 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2270 {
    //2270. 分割数组的方案数
    //给你一个下标从 0 开始长度为 n 的整数数组 nums 。
    //如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
    //
    //前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
    //下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
    //请你返回 nums 中的 合法分割 方案数。
    //
    //
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        //前缀和
        //包括当前位置的前面的和为多少
        long[] dp=new long[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]+nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            long left=dp[i];
            long right=dp[nums.length-1]-left;
            if(left>=right){
                ans++;
            }
        }
        return ans;
    }
}
