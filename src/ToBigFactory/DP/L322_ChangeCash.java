package ToBigFactory.DP;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-07-29 16:38 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L322_ChangeCash - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  16:38 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  16 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L322_ChangeCash {
    //322. 零钱兑换
    //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。
    public int coinChange(int[] coins, int amount) {
        //dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        //背包问题
        //dp[i]=Math.min(dp[i-coins[j]]+1,dp[i])
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i==0){
                    continue;
                }
                if(coins[j]>amount){
                    continue;
                }
                if(i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
