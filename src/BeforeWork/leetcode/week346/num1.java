package leetcode.week346;

/**
 * @author Etherstrings
 * @create 2023-05-23 11:46 leetcode.week346 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/23 - the current system date.  11:46 - the current system time.  2023 - the current year.  05 - the current month.  23 - the current day of the month.  11 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int minLength(String s) {
        while(s.contains("AB")||s.contains("CD")){
            s=s.replace("AB","");
            s=s.replace("CD","");
        }
        return s.length();
    }
}
