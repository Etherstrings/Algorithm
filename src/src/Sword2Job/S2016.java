package src.Sword2Job;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-04-06 10:34 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S2016 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/6 - the current system date.  10:34 - the current system time.  2022 - the current year.  04 - the current month.  06 - the current day of the month.  10 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class S2016 {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
    //
    // 
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //示例 4:
    //
    //输入: s = ""
    //输出: 0
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        int left=0;

        //窗口
        List<Character> chars = new ArrayList<>();
        int max=0;

        for(int right=0;right<s.length();right++){

            //如果窗口里有新的右边
            //现在保证的是里面没有新的
            //那就挨个删除 直到删掉与新右边重复的位置
            while(left<right&&chars.contains(s.charAt(right))){
                chars.remove(0);
                left++;
            }

            chars.add(s.charAt(right));

            max=Math.max(right-left+1,max);
        }

        return max;

    }
}
