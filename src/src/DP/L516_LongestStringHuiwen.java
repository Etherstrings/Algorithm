package src.DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-02 14:32
 */
public class L516_LongestStringHuiwen {
    //516. 最长回文子序列
    //给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
    //
    //子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "bbbab"
    //输出：4
    //解释：一个可能的最长回文子序列为 "bbbb" 。
    //示例 2：
    //
    //输入：s = "cbbd"
    //输出：2
    //解释：一个可能的最长回文子序列为 "bb" 。
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp=new int[s.length()][s.length()];

        //初始化
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],Math.max(dp[i][j],dp[i][j-1]));
                }
            }

        }
        return dp[0][s.length()-1];
    }
}
