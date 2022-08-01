package DP;

/**
 * @author Etherstrings
 * @create 2022-07-31 17:51 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L188_BuyStockIV - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  17:51 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  17 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L188_BuyStockIV {

    //188. 买卖股票的最佳时机 IV
    //给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //
    //
    //示例 1：
    //
    //输入：k = 2, prices = [2,4,1]
    //输出：2
    //解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
    //示例 2：
    //
    //输入：k = 2, prices = [3,2,6,5,0,3]
    //输出：7
    //解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
    //     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int len = prices.length;
        int[][] dp = new int[len][k*2 + 1];

        // dp数组的初始化, 与版本一同理
        for (int i = 1; i < k*2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k*2 - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k*2];
    }
}
