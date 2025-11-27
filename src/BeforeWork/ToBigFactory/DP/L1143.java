package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-30 15:13 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1143 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  15:13 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  15 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            char char1=text1.charAt(i-1);
            for(int j=1;j<=text2.length();j++){
                char char2=text2.charAt(j);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
