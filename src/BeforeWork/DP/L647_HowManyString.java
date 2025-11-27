package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-02 13:49
 */
public class L647_HowManyString {
    //647. 回文子串
    //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
    //
    //回文字符串 是正着读和倒过来读一样的字符串。
    //
    //子字符串 是字符串中的由连续字符组成的一个序列。
    //
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "abc"
    //输出：3
    //解释：三个回文子串: "a", "b", "c"
    //示例 2：
    //
    //输入：s = "aaa"
    //输出：6
    //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

    public int countSubstrings(String s) {
        //dp[i][j]----左边为i 右边为j [i,j]是不是回文串
        boolean[][] dp=new boolean[s.length()][s.length()];

        //默认初始值---赋值为false
        //遍历

        //从下往上 从左往右遍历
        int result=0;
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                //两边的字母一致----才能够进行下一步
                if(s.charAt(i)==s.charAt(j)){
                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                    if(j-i<=1){
                        result++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j]=true;
                    }
                }else {
                    dp[i][j]=false;
                }
            }
        }
        return result;

    }

    public int countSubstrings1(String s){
        //双指针方法
        int len,ans=0;
        if(s==null||(len=s.length())<1) return 0;

        //哪个点可以作为中心点开始判断？
        for(int i=0;i<2*len-1;i++){
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left=i/2,right=left+i%2;
            while(left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}
