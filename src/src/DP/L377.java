package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-27 19:45 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L377 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  19:45 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  19 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L377 {
    //377. 组合总和 Ⅳ
    //给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
    //
    //题目数据保证答案符合 32 位整数范围。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3], target = 4
    //输出：7
    //解释：
    //所有可能的组合为：
    //(1, 1, 1, 1)
    //(1, 1, 2)
    //(1, 2, 1)
    //(1, 3)
    //(2, 1, 1)
    //(2, 2)
    //(3, 1)
    //请注意，顺序不同的序列被视作不同的组合。
    //示例 2：
    //
    //输入：nums = [9], target = 3
    //输出：0
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int j=0;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]){
                    //如果当前的背包容量大于当前的数值
                    dp[j]+=dp[j-nums[i]];
                }

            }
        }
        return dp[target];
    }

}
