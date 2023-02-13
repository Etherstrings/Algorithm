package src.DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-02 14:46
 */
public class L5_LongestHuiwen {
    //5. 最长回文子串
    //给你一个字符串 s，找到 s 中最长的回文子串。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案。
    //示例 2：
    //
    //输入：s = "cbbd"
    //输出："bb"
    public String longestPalindrome(String s){
        //最长的回文子串
        //dp[i][j] 左边为i 右边为j 是不是回文?
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        int left=0;
        int right=0;
        int maxlenght=0;
        //遍历的顺序+递归的条件
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                //核心条件就是左边是不是等于右边？
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]&&j-i+1>maxlenght){
                    maxlenght=j-i+1;
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,maxlenght);
    }
}
