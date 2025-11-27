package SecondTime.Tanxin;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-08-24 14:30 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L455 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  14:30 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  14 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //满足更多的小孩
        int kid=0;
        int size=0;
        while(kid<g.length&&size<s.length){
            //当前小孩
            int k=g[kid];
            //当前饼干
            int b=s[size];
            if(b>=k){
                kid++;
                size++;
            }else {
                size++;
            }
        }
        return kid;
    }
}
