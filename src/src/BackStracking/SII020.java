package src.BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-07 22:17 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII020 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/7 - the current system date.  22:17 - the current system time.  2022 - the current year.  06 - the current month.  07 - the current day of the month.  22 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class SII020 {
    //647. 回文子串
    //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
    //
    //回文字符串 是正着读和倒过来读一样的字符串。
    //
    //子字符串 是字符串中的由连续字符组成的一个序列。
    //
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "abc"
    //输出：3
    //解释：三个回文子串: "a", "b", "c"
    //示例 2：
    //
    //输入：s = "aaa"
    //输出：6
    //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
    //
    //
    //提示：
    //
    //1 <= s.length <= 1000
    //s 由小写英文字母组成


    //思路 多少个字串
    //判断每个字串是不是回文子串
    LinkedList<String> Path=new LinkedList<>();
    List<List<String>> Asnwer=new ArrayList<>();
    public int countSubstrings(String s) {
        BackTarcking(s,0);
        int answer=0;

        for(List<String> a:Asnwer){

            for(String c:a){
                if(isHuiwen(c)){
                    answer+=1;
                }
            }

        }
        return answer;
    }

    void BackTarcking(String s,int index){
        if(index>=s.length()){
            Asnwer.add(new ArrayList<>(Path));
            return;
        }
        for(int i=index;i<s.length();i++){
            String temp=s.substring(index,i+1);

                Path.add(temp);
                BackTarcking(s,i+1);
                Path.removeLast();

        }
    }

    boolean isHuiwen(String s){
        if(s.length()==0){
            return false;
        }
        if(s.length()==1){
            return true;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return true;
            }else {
                return false;
            }
        }
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
