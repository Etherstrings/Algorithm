package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-01 14:34
 */
public class L1143_LongestStringIII {
    //1143. 最长公共子序列
    //给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
    //
    //一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    //
    //例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    //两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
    //
    //
    //
    //示例 1：
    //
    //输入：text1 = "abcde", text2 = "ace"
    //输出：3
    //解释：最长公共子序列是 "ace" ，它的长度为 3 。
    //示例 2：
    //
    //输入：text1 = "abc", text2 = "abc"
    //输出：3
    //解释：最长公共子序列是 "abc" ，它的长度为 3 。
    //示例 3：
    //
    //输入：text1 = "abc", text2 = "def"
    //输出：0
    //解释：两个字符串没有公共子序列，返回 0 。
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        //递推
        //判断 i-1 和 j-1 的字符是不是相等
        //如果相等 那就是两者前一个状态 +1
        //不相等 就是哪个前一个状态更大
        int[][] dp=new int[text1.length()+1][text2.length()+1];

        //初始化
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=text1.length();i++){
            char char1=text1.charAt(i-1);
            for(int j=1;j<=text2.length();j++){
                char char2=text2.charAt(j-1);

                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
