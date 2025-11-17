package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-29 21:46 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L121_BuyStock_I - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  21:46 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  21 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L121_BuyStock_I {
    public static int maxProfit(int[] prices){
        //第i天，持有以及未持有的最大利润
        int[][] dp=new int[prices.length+1][2];
        //0 持有
        //1 未持有
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);

            //当前不持有
            //之前持有 今天卖了
            //之前就不持有
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
