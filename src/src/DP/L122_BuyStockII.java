package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-31 17:16 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L122_BuyStockII - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  17:16 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  17 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L122_BuyStockII {

    public int maxProfit(int[] prices){
        //dp[i][0] ----表示第i天持有股票所拥有的现金
        //dp[i][1] ----表示第i天不持有股票所拥有的现金

        int[][] dp=new int[prices.length][2];

        //如果第一天持有股票 那么现在的现金就是负数
        dp[0][0]-=0;
        dp[0][1]=-prices[0];

        for(int i=0;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，持有股票
        }
        return dp[prices.length][0];
    }
}
