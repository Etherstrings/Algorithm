package DP;

/**
 * @author Etherstrings
 * @create 2023-02-18 0:42 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1974 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/18 - the current system date.  0:42 - the current system time.  2023 - the current year.  02 - the current month.  18 - the current day of the month.  00 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1974 {
    public int minTimeToType(String word) {
        int[] dp=new int[word.length()];
        char before='a';
        for(int i=0;i<word.length();i++){
            char now=word.charAt(i);
            if(i==0){
                if(now==before){
                    dp[0]=1;
                }else {
                    int small=Math.min(Math.abs(now-before),(26-Math.abs(now-before)));
                    dp[0]=small+1;
                    before=now;
                }
                continue;
            }
            dp[i]=Math.min(dp[i-1]+Math.abs(now-before),dp[i-1]+(26-Math.abs(now-before)))+1;
            before=now;
        }
        return dp[word.length()-1];
    }
}
