package ToBigFactory.DP;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-07-29 19:35 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L139_SpitWord_dp - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  19:35 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  19 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L139_SpitWord_dp {
    //139. 单词拆分
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    //
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    //示例 2：
    //
    //输入: s = "applepenapple", wordDict = ["apple", "pen"]
    //输出: true
    //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    //     注意，你可以重复使用字典中的单词。
    //示例 3：
    //
    //输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    //输出: false
    public boolean wordBreak(String s, List<String> wordDict) {
        //当前这个长度，能不能被拼成?
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if(i==0){
                continue;
            }
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
