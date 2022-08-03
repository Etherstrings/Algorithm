package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-02 11:01
 */
public class L583_2DeleteString {
    //583. 两个字符串的删除操作
    //给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
    //
    //每步 可以删除任意一个字符串中的一个字符。
    //
    //
    //
    //示例 1：
    //
    //输入: word1 = "sea", word2 = "eat"
    //输出: 2
    //解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
    //示例  2:
    //
    //输入：word1 = "leetcode", word2 = "etco"
    //输出：4
    public int minDistance(String word1, String word2) {
        //还是两个都可以删除
        //dp的意义
        //dp[i][j]
        //s为i-1 j为i-1时 s和t能够达到相同的 最小的删除次数

        //递推
        //看 s i-1 和 t j-1 是不是相同
        //如果相同 那这俩都不用删除 直接就是上一个的状态
        //如果不同 删s 删t s和t都删一次

        //初始化
        //dp[0][0] 不用删除 应该赋值为0
        //dp[0][j] s为空 j删几次？ 删当前到的所有字符
        //dp[i][0] t为空 s删几次？ 删当前的所有字符
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for(int i=1;i<word1.length()+1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<word2.length()+1;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    //相同 那不用删 可以当做无事发生
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+2);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
