package src.SecondTime.Tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-27 12:58 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L763 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/27 - the current system date.  12:58 - the current system time.  2022 - the current year.  08 - the current month.  27 - the current day of the month.  12 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(int i=0;i<s.length();i++){
            //记录当前字母出现的最后位置
            Judge.put(s.charAt(i),i);
        }
        //记录当前含有字母的最后一个出现位置
        //里面所含字母的最大的一个位置
        List<Integer> answer=new ArrayList<>();
        int lastone=-1;
        int start=0;
        for(int i=0;i<s.length();i++){
            lastone=Math.max(Judge.get(s.charAt(i)),lastone);

            if(i==lastone){
                int temp=lastone-start+1;
                answer.add(temp);
                start=lastone+1;
            }
        }
        return answer;
    }
}
