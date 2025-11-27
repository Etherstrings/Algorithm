package StringExer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-06-21 0:03 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L389 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/21 - the current system date.  0:03 - the current system time.  2022 - the current year.  06 - the current month.  21 - the current day of the month.  00 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L389 {
    //389. 找不同
    //给定两个字符串 s 和 t ，它们只包含小写字母。
    //
    //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //
    //请找出在 t 中被添加的字母。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "abcd", t = "abcde"
    //输出："e"
    //解释：'e' 是那个被添加的字母。
    //示例 2：
    //
    //输入：s = "", t = "y"
    //输出："y"
    //
    //
    //提示：
    //
    //0 <= s.length <= 1000
    //t.length == s.length + 1
    //s 和 t 只包含小写字母
    //通过次数129,893提交次数190,475
    public char findTheDifference(String s, String t) {
        //t由s重新排列然后加一个的来
        ArrayList<Character> Judge=new ArrayList<>();
        for(Character a:t.toCharArray()){
            Judge.add(a);
        }
        for(Character a:s.toCharArray()){
            Judge.remove(a);
        }
        return Judge.get(0);
    }
}
