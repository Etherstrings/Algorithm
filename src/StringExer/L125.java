package StringExer;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-13 15:50 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L125 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/13 - the current system date.  15:50 - the current system time.  2022 - the current year.  06 - the current month.  13 - the current day of the month.  15 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
//125. 验证回文串
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//说明：本题中，我们将空字符串定义为有效的回文串。
//
//
//
//示例 1:
//
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
//示例 2:
//
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
public class L125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W[_]]", "").toLowerCase();
        char[] chars = s.toCharArray();
        ArrayList<Character> Achar=new ArrayList<Character>();
        for(int i=0;i<chars.length;i++){
            Achar.add(chars[i]);
        }
        ArrayList<Character> test=new ArrayList<Character>();
        for(int i=0;i<Achar.size();i++){
            test.add(Achar.get(i));
        }
        Collections.reverse(test);
        for(int i=0;i<test.size();i++){
            if(test.get(i)!=Achar.get(i)){
                return false;
            }
        }
        return true;
    }

}
