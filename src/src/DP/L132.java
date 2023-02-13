package src.DP;

/**
 * @author Etherstrings
 * @create 2022-09-14 0:12 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L132 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  0:12 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  00 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L132 {
    //132. 分割回文串 II
    //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
    //
    //返回符合要求的 最少分割次数 。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "aab"
    //输出：1
    //解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
    //示例 2：
    //
    //输入：s = "a"
    //输出：0
    //示例 3：
    //
    //输入：s = "ab"
    //输出：1

    //dp[i]：范围是[0, i]的回文子串，最少分割次数是dp[i]。
    public int minCut(String s) {
        if(null == s || "".equals(s)){
            return 0;
        }
        int len = s.length();
        // 1.
        // 记录子串[i..j]是否是回文串
        boolean[][] isPalindromic = new boolean[len][len];
        // 从下到上，从左到右
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        isPalindromic[i][j] = true;
                    } else{
                        isPalindromic[i][j] = isPalindromic[i + 1][j - 1];
                    }
                } else{
                    isPalindromic[i][j] = false;
                }
            }
        }

        // 2.
        // dp[i] 表示[0..i]的最小分割次数
        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            //初始考虑最坏的情况。 1个字符分割0次， len个字符分割 len - 1次
            dp[i] = i;
        }

        for(int i = 1; i < len; i++){
            if(isPalindromic[0][i]){
                // s[0..i]是回文了，那 dp[i] = 0, 一次也不用分割
                dp[i] = 0;
                continue;
            }
            for(int j = 0; j < i; j++){
                // 按文中的思路，不清楚就拿 "ababa" 为例，先写出 isPalindromic 数组，再进行求解
                if(isPalindromic[j + 1][i]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
