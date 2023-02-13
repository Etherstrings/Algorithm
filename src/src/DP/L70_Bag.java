package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-27 19:57 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L70_Bag - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  19:57 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  19 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L70_Bag {
    public int climbStairs(int n){
        //从1-n 每个都可以无限取
        //填到n 有多少个取法？
        //dp[i]+=dp[i-j]

        //完全背包问题
        int[] dp=new int[n+1];
        int[] weight={1,2};
        dp[1]=1;
        dp[0]=1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<weight.length;j++){
                if (i >= weight[j]){
                    dp[i]=dp[i-weight[j]];
                }

            }
        }

        return dp[n];
    }
}
