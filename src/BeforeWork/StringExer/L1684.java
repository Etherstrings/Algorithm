package StringExer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-11-08 18:18 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1684 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/8 - the current system date.  18:18 - the current system time.  2022 - the current year.  11 - the current month.  08 - the current day of the month.  18 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> jd=new HashSet<>();
        for(char a:allowed.toCharArray()){
            jd.add(a);
        }
        int ans=0;
        for(String word:words){
            boolean flag=true;
            for(char c:word.toCharArray()){
                if(jd.contains(c)){
                    continue;
                }else {
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }
}
