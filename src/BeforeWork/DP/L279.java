package DP;

/**
 * @author Etherstrings
 * @create 2022-07-27 20:21 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L279 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  20:21 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  20 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L279 {
    //279. 完全平方数
    //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
    //
    //完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 12
    //输出：3
    //解释：12 = 4 + 4 + 4
    //示例 2：
    //
    //输入：n = 13
    //输出：2
    //解释：13 = 4 + 9
    public int numSquares(int n) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i]=max;
        }

        dp[0]=0;

        for(int i=1;i*i<=n;i++){
            for(int j=i*i;j<=n;j++){
                if(dp[j-i*i]!=max){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
