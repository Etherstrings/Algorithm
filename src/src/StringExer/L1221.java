package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-09-03 18:14 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1221 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  18:14 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  18 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L1221 {
    public int balancedStringSplit(String s) {
        int ans=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                count++;
            }else {
                count--;
            }
            if(count==0){
                ans++;
            }
        }
        return ans;
    }
}
