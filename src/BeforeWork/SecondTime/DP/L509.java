package SecondTime.DP;

/**
 * @author Etherstrings
 * @create 2022-08-29 14:25 SecondTime.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L509 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  14:25 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  14 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp=new int[n+1];
        //当前的数值
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
