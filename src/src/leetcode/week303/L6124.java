package src.leetcode.week303;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-24 10:59 leetcode.week303 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6124 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/24 - the current system date.  10:59 - the current system time.  2022 - the current year.  07 - the current month.  24 - the current day of the month.  10 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6124 {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> Judge=new HashMap<>();
        char temp='a';
        for(int i=0;i<s.length();i++){
            if(Judge.containsKey(s.charAt(i))){
                //现在里面已经有一个了
                if(Judge.get(s.charAt(i))==1){
                    temp=s.charAt(i);
                    break;
                }
            }else {
                Judge.put(s.charAt(i),1);
            }
        }
        return temp;
    }
}
