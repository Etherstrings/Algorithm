package src.Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-03-11 9:43 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L48 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/11 - the current system date.  9:43 - the current system time.  2022 - the current year.  03 - the current month.  11 - the current day of the month.  09 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L48 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> judge=new HashMap<>();
        char[] chars = s.toCharArray();

        if(s.equals("")){
            return 0;
        }
        if(chars.length==1){
            return 1;
        }

        int max=0;
        int left=0;
        for(int right=0;right<chars.length;right++){
            if(judge.containsKey(chars[right])){
                left=Math.max(left,judge.get(chars[right])+1);
            }
            judge.put(chars[right],right );
            max=Math.max(max,right-left+1);
        }

        return max;
    }
}
