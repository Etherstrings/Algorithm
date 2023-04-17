package MovingWindow;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-02-25 14:13 MovingWindow - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L567 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  14:13 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  14 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L567 {
    public boolean checkInclusion(String s1, String s2) {
        //s1的所有排列？
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] i1=new int[26];
        int[] i2=new int[26];
        for (int i = 0; i < n; ++i) {
            ++i1[s1.charAt(i) - 'a'];
            ++i2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(i1,i2)) {
            return true;
        }
        for(int i=n;i<m;i++){
            ++i2[s2.charAt(i) - 'a'];
            --i2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(i1,i2)) {
                return true;
            }
        }
        return false;
    }
}
