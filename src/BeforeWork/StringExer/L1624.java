package StringExer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-09-17 17:11 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1624 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  17:11 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  17 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> left=new HashMap<>();
        Map<Character,Integer> right=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            right.put(s.charAt(i),i);
            set.add(s.charAt(i));
        }
        for(int i=s.length()-1;i>=0;i--){
            left.put(s.charAt(i),i);
        }
        int max=-1;
        for(Character a:set){
            if(right.get(a)==left.get(a)){
                continue;
            }else if(right.get(a)-left.get(a)==1){
                //相邻
                max=Math.max(0,max);
            }else {
                max=Math.max(max,right.get(a)-left.get(a)-1);
            }
        }
        return max;
    }
}
