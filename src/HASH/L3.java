package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-02-25 11:02 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  11:02 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L3 {
    //3. 无重复字符的最长子串
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> Judgement = new HashMap<>();
        char[] chars = s.toCharArray();

        if (s.equals("")) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int max = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (Judgement.containsKey(chars[right])) {
                left = Math.max(left,Judgement.get(chars[right])+1);


            }
            Judgement.put(chars[right], right);
            max=Math.max(max,right-left+1);


        }
        return max;
    }
}
