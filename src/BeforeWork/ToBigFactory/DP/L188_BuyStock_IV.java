package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-29 22:31 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L188_BuyStock_IV - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  22:31 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  22 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L188_BuyStock_IV {
    //n次买
    public static int maxProfit(int[] prices,int k){
        int[][][] dp=new int[prices.length+1][k+1][2];
        //0没有
        //1有
        for(int i=0;i<=k;i++){
            dp[0][i][1]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                //当前一天，没有股票了
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                //当前这一天，还有股票
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j][0]-prices[i]);
            }
        }
        return dp[prices.length-1][k][0];
    }
}
