package src.leetcode.week317;

/**
 * @author Etherstrings
 * @create 2022-11-01 14:46 leetcode.week317 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2455 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/1 - the current system date.  14:46 - the current system time.  2022 - the current year.  11 - the current month.  01 - the current day of the month.  14 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L2455 {
    public static int averageValue(int[] nums) {
        int n=0;
        int sum=0;
        for(int now:nums){
            if(now%2==0&&now%3==0){
                n++;
                sum+=now;
            }
        }
        if(n==0){
            return 0;
        }
        return sum/n;
    }
}
