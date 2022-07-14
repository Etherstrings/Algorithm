package BackStracking;

import java.util.ArrayList;
import java.util.List;

public class L784 {
    //给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
    //
    //返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "a1b2"
    //输出：["a1b2", "a1B2", "A1b2", "A1B2"]
    //示例 2:
    //
    //输入: s = "3z4"
    //输出: ["3z4","3Z4"]
    List<String> ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        //思路
        //这个不是回溯---是递归
        StringBuilder Path=new StringBuilder(s);
        tonext(s,0,Path);
        return ans;
    }

    void tonext(String s,int startindex,StringBuilder Path){
        if(startindex==s.length()){
            ans.add(Path.toString());
            return;
        }

        if(Character.isDigit(s.charAt(startindex))){
            Path.setCharAt(startindex,s.charAt(startindex));
            tonext(s,startindex+1,Path);
        }else if(Character.isLowerCase(s.charAt(startindex))){
            Path.setCharAt(startindex,s.charAt(startindex));
            tonext(s,startindex+1,Path);
            Path.setCharAt(startindex,Character.toUpperCase(s.charAt(startindex)));
            tonext(s,startindex+1,Path);
        }else {
            Path.setCharAt(startindex,s.charAt(startindex));
            tonext(s,startindex+1,Path);
            Path.setCharAt(startindex,Character.toLowerCase(s.charAt(startindex)));
            tonext(s,startindex+1,Path);
        }
    }


}
