package WeiYunSuan;

/**
 * @author Etherstrings
 * @create 2023-03-07 0:40 WeiYunSuan - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L231 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/7 - the current system date.  0:40 - the current system time.  2023 - the current year.  03 - the current month.  07 - the current day of the month.  00 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L231 {

    //4 100
    //3 011
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }

        return (n & (n-1))==0;
    }
}
