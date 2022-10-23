/**
 * @author Etherstrings
 * @create 2022-09-16 11:44 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Find2Is2N - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  11:44 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  11 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Find2Is2N {
    public boolean demo(int n){
        // 2 的幂不小于 0
        if(n <= 0){
            return false;
        }

        if(0 == (n & (n - 1))){
            return true;
        }

        return false;
    }
}
