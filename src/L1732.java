import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-11-19 14:00 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1732 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/19 - the current system date.  14:00 - the current system time.  2022 - the current year.  11 - the current month.  19 - the current day of the month.  14 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1732 {
    public int largestAltitude(int[] gain) {
        int max=0;
        //0 0
        HashMap
        int[] dp=new int[gain.length+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            int index=i-1;
            int now=dp[i-1]+gain[index];
            dp[i]=now;
            max=Math.max(now,max);
        }
        return max;
    }
}
