package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-28 21:35 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L213_StealII - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  21:35 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  21 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L213_StealII {
    //213. 打家劫舍 II
    //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,3,2]
    //输出：3
    //解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
    //示例 2：
    //
    //输入：nums = [1,2,3,1]
    //输出：4
    //解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
    //     偷窃到的最高金额 = 1 + 3 = 4 。
    //示例 3：
    //
    //输入：nums = [1,2,3]
    //输出：3
    public int rob(int[] nums) {
        //第一间房和最后一间房紧挨
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int a=robrange(0,nums.length-2,nums);
        int b=robrange(1,nums.length-1,nums);
        return Math.max(a,b);
    }

    int robrange(int start,int end,int[] nums){
        if(start==end){
            return nums[start];
        }
        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
