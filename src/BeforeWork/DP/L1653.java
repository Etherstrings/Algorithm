package DP;

/**
 * @author Etherstrings
 * @create 2023-03-06 23:40 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1653 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/6 - the current system date.  23:40 - the current system time.  2023 - the current year.  03 - the current month.  06 - the current day of the month.  23 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1653 {

    //dp[i]
    //当前位置达到平衡，所需要的最小删除次数

    //当前的状态有几种？
    //当前要不然是a 要不然是b
    //aaaa
    //bbbb
    //aaaabbbb
    public int minimumDeletions(String s) {
        int[] dp=new int[s.length()];
        int count=0;
        dp[0]=0;
        if(s.charAt(0)=='b'){
            count++;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='b'){
                count++;
                dp[i]=dp[i-1];
            }else {
                dp[i]=Math.min(dp[i-1]+1,count);
            }
        }
        return dp[s.length()-1];
    }
}
