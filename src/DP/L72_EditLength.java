package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-02 11:28
 */
public class L72_EditLength {
    //72. 编辑距离
    //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
    //
    //你可以对一个单词进行如下三种操作：
    //
    //插入一个字符
    //删除一个字符
    //替换一个字符
    //
    //
    //示例 1：
    //
    //输入：word1 = "horse", word2 = "ros"
    //输出：3
    //解释：
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
    //示例 2：
    //
    //输入：word1 = "intention", word2 = "execution"
    //输出：5
    //解释：
    //intention -> inention (删除 't')
    //inention -> enention (将 'i' 替换为 'e')
    //enention -> exention (将 'n' 替换为 'x')
    //exention -> exection (将 'n' 替换为 'c')
    //exection -> execution (插入 'u')
    public int minDistance(String word1, String word2) {
        //dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
        //最近编辑距离是什么？
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        //初始化
        dp[0][0]=0;
        for(int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=word2.length();i++){
            dp[0][i]=i;
        }

        //递推
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    //相同 沿用上一个状态
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //增删改
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
