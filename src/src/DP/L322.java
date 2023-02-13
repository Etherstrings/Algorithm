package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-27 20:12 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L322 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  20:12 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  20 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L322 {
    //322. 零钱兑换
    //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。
    //
    //
    //
    //示例 1：
    //
    //输入：coins = [1, 2, 5], amount = 11
    //输出：3
    //解释：11 = 5 + 5 + 1
    //示例 2：
    //
    //输入：coins = [2], amount = 3
    //输出：-1
    //示例 3：
    //
    //输入：coins = [1], amount = 0
    //输出：0
    //
    //
    //提示：
    //
    //1 <= coins.length <= 12
    //1 <= coins[i] <= 231 - 1
    //0 <= amount <= 104
    public int coinChange(int[] coins, int amount) {
        //dp[j] 当前数量的钱币需要的硬币数

        //dp[j]+=Min(dp[j],dp[j-coins[i]]+1);

        //dp[0]=0

        //其余的设为最大数

        //完全怎么遍历

        //先物品
        //里面是背包
        int[] dp=new int[amount+1];

        for(int i=0;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }


            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}
