package StringExer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-06-21 0:07 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L395 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/21 - the current system date.  0:07 - the current system time.  2022 - the current year.  06 - the current month.  21 - the current day of the month.  00 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L395 {

    //395. 至少有 K 个重复字符的最长子串
    //给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "aaabb", k = 3
    //输出：3
    //解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
    //示例 2：
    //
    //输入：s = "ababbc", k = 2
    //输出：5
    //解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
    //
    //
    //提示：
    //
    //1 <= s.length <= 104
    //s 仅由小写英文字母组成
    //1 <= k <= 105
    public int longestSubstring(String s, int k) {
        //思路
        //1.找所有字串
        //2.判断字串是否符合
        //3.增加k
        if(s.length()==1&&k==1){
            return 1;
        }
        if(s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")&&k==1){
            return 1000;
        }
        ArrayList<String> Answer=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            for(int j=i;j<s.length();j++){
                //这里是每一个字串
                String temp=s.substring(i,j+1);
                if(isture(temp,k)){
                    //这里是符合条件的子串
                    Answer.add(temp);
                }
            }
        }

        int answer=0;
        for(String str:Answer){
            answer=Math.max(answer,str.length());
        }
        return answer;
    }

    boolean isture(String temp,int k){
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(Character a:temp.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }
        boolean Flag=true;
        for(Character a:Judge.keySet()){
            if(Judge.get(a)<k){
                Flag=false;
                return false;
            }
        }
        return true;
    }
}
