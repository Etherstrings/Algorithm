package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-29 22:11 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L122_BuyStock_II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  22:11 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  22 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L122_BuyStock_II {
    //可以买卖多次
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        //有
        dp[0][0]=-prices[0];
        //无
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            //原来就没有+昨天还有
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);

            //昨天就有+昨天没有
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
