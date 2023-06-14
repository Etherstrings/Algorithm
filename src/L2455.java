/**
 * @author Etherstrings
 * @create 2023-05-29 16:46 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2455 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/29 - the current system date.  16:46 - the current system time.  2023 - the current year.  05 - the current month.  29 - the current day of the month.  16 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2455 {
    public int averageValue(int[] nums) {
        int sum=0;
        int size=0;
        for(int n:nums){
            if(n%6==0){
                sum+=n;
                size++;
            }
        }
        return sum==0?0:sum/size;
    }
}
