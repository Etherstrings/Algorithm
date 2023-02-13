package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-28 21:15 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L198_StealI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  21:15 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  21 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L198_StealI {
    //198. 打家劫舍
    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    //
    //
    //
    //示例 1：
    //
    //输入：[1,2,3,1]
    //输出：4
    //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    //     偷窃到的最高金额 = 1 + 3 = 4 。
    //示例 2：
    //
    //输入：[2,7,9,3,1]
    //输出：12
    //解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
    public int rob(int[] nums) {
        //dp -- 偷到当前家的最大钱


        //决定dp[i]的元素是这家偷不偷？
        //如果偷
        //dp[i]=dp[i-2]+nums[i];
        //如果不偷
        //dp[i]=dp[i-1]

        //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0||nums==null){
            return 0;
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
