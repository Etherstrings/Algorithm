package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-24 20:59 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L746 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/24 - the current system date.  20:59 - the current system time.  2022 - the current year.  07 - the current month.  24 - the current day of the month.  20 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L746 {
    //746. 使用最小花费爬楼梯
    //给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
    //
    //你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
    //
    //请你计算并返回达到楼梯顶部的最低花费。
    //
    //
    //
    //示例 1：
    //
    //输入：cost = [10,15,20]
    //输出：15
    //解释：你将从下标为 1 的台阶开始。
    //- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
    //总花费为 15 。
    //示例 2：
    //
    //输入：cost = [1,100,1,1,1,100,1,1,100,1]
    //输出：6
    //解释：你将从下标为 0 的台阶开始。
    //- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
    //- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
    //- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
    //- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
    //- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
    //- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
    //总花费为 6 。
    public int minCostClimbingStairs(int[] cost) {
        //dp[] 当前阶数对应的已花费数

        //递推公式
        //dp[i]----dp[i-1]或者dp[i-2]都可以到达 因为都可以+1或者+2

        //选哪个呢？
            //选当前最少的---加上当前的值
            //每当你爬上一个阶梯你都要花费对应的体力值---重要
        //因此 dp[i]=Min(dp[i-1],dp[i-2])+cost[i]
        if(cost.length==1){
            return cost[0];
        }
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
         for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

}
