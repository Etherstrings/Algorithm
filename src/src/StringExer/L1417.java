package src.StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-11 0:03 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1417 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/11 - the current system date.  0:03 - the current system time.  2022 - the current year.  08 - the current month.  11 - the current day of the month.  00 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1417 {
    //1417. 重新格式化字符串
    //给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
    //
    //请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
    //
    //请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "a0b1c2"
    //输出："0a1b2c"
    //解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
    //示例 2：
    //
    //输入：s = "leetcode"
    //输出：""
    //解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
    //示例 3：
    //
    //输入：s = "1229857369"
    //输出：""
    //解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
    //示例 4：
    //
    //输入：s = "covid2019"
    //输出："c2o0v1i9d"
    //示例 5：
    //
    //输入：s = "ab123"
    //输出："1a2b3"
    public String reformat(String s) {
        int num=0;
        int ch=0;
        List<Character> Num=new ArrayList<>();
        List<Character> Char=new ArrayList<>();
        for(char a:s.toCharArray()){
            if(Character.isLetter(a)){
                Char.add(a);
                ch++;
            }else {
                Num.add(a);
                num++;
            }
        }
        int diff=Math.max(num,ch)-Math.min(num,ch);
        if(diff!=0){
            if(diff!=1){
                return "";
            }
        }
        String ans="";
        if(num==ch){
            while(num>0){
                ans+=Num.get(num-1);
                ans+=Char.get(ch-1);
                num--;
                ch--;
            }
        }else if(num>ch){
            //先数字
            while (num>0){
                ans+=Num.get(num-1);
                num--;
                if(ch==0){
                    continue;
                }
                ans+=Char.get(ch-1);
                ch--;
            }

        }else if(num<ch){
            //先字母
            while(ch>0){
                ans+=Char.get(ch-1);
                ch--;
                if(num==0){
                    continue;
                }
                ans+=Num.get(ch-1);
                num--;
            }
        }
        return ans;

    }
}
