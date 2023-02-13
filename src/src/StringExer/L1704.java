package src.StringExer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-11-11 20:13 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1704 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/11 - the current system date.  20:13 - the current system time.  2022 - the current year.  11 - the current month.  11 - the current day of the month.  20 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        s = s.toLowerCase();
        int a=0;
        int b=0;
        int mid=s.length()/2;
        for(int i=0;i<mid;i++){
            if(set.contains(s.charAt(i))){
                a++;
            }
        }
        for(int i=mid;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                b++;
            }
        }
        return a==b;
    }
}
