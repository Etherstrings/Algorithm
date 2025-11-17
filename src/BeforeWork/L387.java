import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-06-20 23:56 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L387 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/20 - the current system date.  23:56 - the current system time.  2022 - the current year.  06 - the current month.  20 - the current day of the month.  23 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L387 {

    //387. 字符串中的第一个唯一字符
    //给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "leetcode"
    //输出: 0
    //示例 2:
    //
    //输入: s = "loveleetcode"
    //输出: 2
    //示例 3:
    //
    //输入: s = "aabb"
    //输出: -1
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(Judge.containsKey(s.charAt(i))){
                Judge.put(s.charAt(i),Judge.get(s.charAt(i))+1);
            }else {
                Judge.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(Judge.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
