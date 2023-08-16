package DP;

/**
 * @author Etherstrings
 * @create 2023-08-08 17:11 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1749 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/8 - the current system date.  17:11 - the current system time.  2023 - the current year.  08 - the current month.  08 - the current day of the month.  17 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1749 {
    //1749. 任意子数组和的绝对值的最大值
    //提示
    //中等
    //92
    //相关企业
    //给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
    //
    //请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
    //
    //abs(x) 定义如下：
    //
    //如果 x 是负整数，那么 abs(x) = -x 。
    //如果 x 是非负整数，那么 abs(x) = x 。
    //
    //
    //示例 1：
    //
    //输入：nums = [1,-3,2,3,-4]
    //输出：5
    //解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
    //示例 2：
    //
    //输入：nums = [2,-5,1,-4,3,-2]
    //输出：8
    //解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
    public int maxAbsoluteSum(int[] nums) {
        //连续子数组
        int ans = 0, fMax = 0, fMin = 0;
        for (int x : nums) {
            fMax = Math.max(fMax, 0) + x;
            fMin = Math.min(fMin, 0) + x;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }

        return ans;
    }
}
