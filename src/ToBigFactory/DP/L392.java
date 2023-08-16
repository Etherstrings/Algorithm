package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-30 17:14 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L392 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  17:14 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  17 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L392 {
    //判断s是不是t的子串
    public boolean isSubsequence(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[len1][len2]==len1?true:false;
    }
}
