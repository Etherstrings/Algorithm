package TanXin;

/**
 * @author Etherstrings
 * @create 2023-05-23 14:52 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2697 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/23 - the current system date.  14:52 - the current system time.  2023 - the current year.  05 - the current month.  23 - the current day of the month.  14 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2697 {
    public String makeSmallestPalindrome(String s) {
        int n=s.length();
        char[] chars=s.toCharArray();
        for(int i=0;i<n/2;i++){
            chars[i]=chars[n-i-1]=(char)Math.min(chars[n-i-1],chars[i]);
        }
        return new String(chars);
    }
}
