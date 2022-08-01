package DP;

/**
 * @author Etherstrings
 * @create 2022-07-31 18:37 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L309_BuyStock_Clod - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  18:37 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  18 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L309_BuyStock_Clod {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
