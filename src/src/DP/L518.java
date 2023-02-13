package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-27 19:28 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L518 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  19:28 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  19 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L518 {
    //518. 零钱兑换 II
    //给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
    //
    //请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
    //
    //假设每一种面额的硬币有无限个。
    //
    //题目数据保证结果符合 32 位带符号整数。
    //
    //
    //
    //示例 1：
    //
    //输入：amount = 5, coins = [1, 2, 5]
    //输出：4
    //解释：有四种方式可以凑成总金额：
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    //示例 2：
    //
    //输入：amount = 3, coins = [2]
    //输出：0
    //解释：只用面额 2 的硬币不能凑成总金额 3 。
    //示例 3：
    //
    //输入：amount = 10, coins = [10]
    //输出：1
    public int change(int amount, int[] coins) {
        //dp数组
        //dp[j] 当前价值对应的能组成的组合

        //递推公式
        //因为当前这一步 实际上是可以从上一个状态选另一个来决定的
        //dp[j]+=dp[j-coins[i]];
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }

        return dp[amount];

    }
}
