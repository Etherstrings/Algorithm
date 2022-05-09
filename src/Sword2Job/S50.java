package Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-04-19 21:32 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S50 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/19 - the current system date.  21:32 - the current system time.  2022 - the current year.  04 - the current month.  19 - the current day of the month.  21 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class S50 {
    //剑指 Offer 50. 第一个只出现一次的字符
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    //
    //示例 1:
    //
    //输入：s = "abaccdeff"
    //输出：'b'
    //示例 2:
    //
    //输入：s = ""
    //输出：' '
    //
    //
    //限制：
    //
    //0 <= s 的长度 <= 50000
    public char firstUniqChar(String s) {
        //思路
        //利用数组 一一对应
        if(s.equals("")){
            return ' ';
        }
        //第一次遍历 存入
        char[] chars = s.toCharArray();
        int[] All=new int[26];
        for(int i=0;i<chars.length;i++){
            All[chars[i]-'a']+=1;
        }
        //第二次遍历 查找
        for(int i=0;i<chars.length;i++){
            if(All[chars[i]-'a']==1){
                return chars[i];
            }
        }
        return ' ';
    }

    //利用Map
    public char firstUniqChar1(String s) {
        if(s.equals("")){
            return ' ';
        }
        Map<Character,Integer> judge=new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!judge.containsKey(chars[i])){
                judge.put(chars[i],1);
            }else {
                judge.put(chars[i],judge.get(chars[i])+1);
            }
        }

        for(int i=0;i<chars.length;i++){
            if(judge.get(chars[i])==1){
                return chars[i];
            }
        }

        return ' ';
    }
}
