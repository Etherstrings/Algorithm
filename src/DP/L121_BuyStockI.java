package DP;

/**
 * @author Etherstrings
 * @create 2022-07-28 22:26 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L121_BuyStockI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  22:26 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  22 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L121_BuyStockI {
    public int maxProfit(int[] prices){
        //dp
        //在这一天卖出的最大收益
        //这一天卖还是不卖？
        //dp[i][0] 表示第i天持有股票所得最多现金
        //dp[i][1] 表示第i天不持有股票所得最多现金
        int[][] dp=new int[prices.length][2];

        dp[0][0]-=prices[0];
        dp[0][1]=0;

        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }

        return dp[prices.length-1][1];
    }
}
