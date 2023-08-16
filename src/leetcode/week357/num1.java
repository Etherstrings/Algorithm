package leetcode.week357;

/**
 * @author Etherstrings
 * @create 2023-08-14 18:45 leetcode.week357 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/14 - the current system date.  18:45 - the current system time.  2023 - the current year.  08 - the current month.  14 - the current day of the month.  18 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public String finalString(String s) {
        StringBuilder sb=new StringBuilder();
        for(char n:s.toCharArray()){
            if(n=='i'){
                StringBuilder reverse = sb.reverse();
                sb=reverse;
                continue;
            }
            sb.append(n);
        }
        return sb.toString();
    }
}
