package DP;

/**
 * @author Etherstrings
 * @create 2022-07-22 14:19 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L509 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/22 - the current system date.  14:19 - the current system time.  2022 - the current year.  07 - the current month.  22 - the current day of the month.  14 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L509 {

    public int fib(int n) {
        //动规五部曲
        //1.确定DP数组以及下标的含义
        //dp[i]  第i个数的值是dp[i] f(n)
        //2.确定递推公式---f(n)怎么来？
        //状态转移方程 dp[i] = dp[i - 1] + dp[i - 2];
        //3.dp数组如何初始化
        //初始条件---根据什么推导？
        //dp[0] = 0; dp[1] = 1;
        //4.确定遍历顺序
        //因为可以从n反推到1
        //或者从1推到n
        //根据公式决定
        //当前的i 根据前一个i-1与i-2决定
        //5.推导dp数组
        if (n <= 1) {
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int index=2;index<=n;index++){
            dp[index]=dp[index-1]+dp[index-2];
        }
        return dp[n];
    }

}
