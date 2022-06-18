import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-06-17 22:16 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L205 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/17 - the current system date.  22:16 - the current system time.  2022 - the current year.  06 - the current month.  17 - the current day of the month.  22 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L205 {
    //205. 同构字符串
    //给定两个字符串 s 和 t ，判断它们是否是同构的。
    //
    //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
    //
    //每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
    //
    //
    //
    //示例 1:
    //
    //输入：s = "egg", t = "add"
    //输出：true
    //示例 2：
    //
    //输入：s = "foo", t = "bar"
    //输出：false
    //示例 3：
    //
    //输入：s = "paper", t = "title"
    //输出：true
    //
    //
    //提示：
    //
    //1 <= s.length <= 5 * 104
    //t.length == s.length
    //s 和 t 由任意有效的 ASCII 字符组成

    public boolean isIsomorphic(String s, String t) {
        //思路

        //这个是第几个出现的新字符？
            //返回按照排序的数字
        Map<Character,Integer> Judge=new HashMap<>();

        ArrayList<Integer> S2ARRAY=new ArrayList<>();
        ArrayList<Integer> T2ARRAY=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(Judge.containsKey(s.charAt(i))){
                S2ARRAY.add(Judge.get(s.charAt(i)));
            }else {
                Judge.put(s.charAt(i),Judge.size()+1);
                S2ARRAY.add(Judge.get(s.charAt(i)));
            }
        }

        Judge=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(Judge.containsKey(t.charAt(i))){
                T2ARRAY.add(Judge.get(t.charAt(i)));
            }else {
                Judge.put(t.charAt(i),Judge.size()+1);
                T2ARRAY.add(Judge.get(t.charAt(i)));
            }
        }

        if(S2ARRAY.equals(T2ARRAY)){
            return true;
        }
        return false;
    }
}
