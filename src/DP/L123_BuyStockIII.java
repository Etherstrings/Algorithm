package DP;

import java.util.Arrays;

import static java.lang.Math.max;

/**
 * @author Etherstrings
 * @create 2022-07-31 17:35 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L123_BuyStockIII - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  17:35 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  17 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L123_BuyStockIII {
    //123. 买卖股票的最佳时机 III
    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //
    //
    //示例 1:
    //
    //输入：prices = [3,3,5,0,0,3,1,4]
    //输出：6
    //解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    //     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
    //示例 2：
    //
    //输入：prices = [1,2,3,4,5]
    //输出：4
    //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    //     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    //示例 3：
    //
    //输入：prices = [7,6,4,3,1]
    //输出：0
    //解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
    //示例 4：
    //
    //输入：prices = [1]
    //输出：0
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}
