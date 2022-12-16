package src;

/**
 * @author Etherstrings
 * @create 2022-05-30 19:48 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L944 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/30 - the current system date.  19:48 - the current system time.  2022 - the current year.  05 - the current month.  30 - the current day of the month.  19 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L944 {
    public int minDeletionSize(String[] strs) {

        int index=strs[0].length();
        int answer=0;
        for(int i=0;i<index;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j-1].charAt(i)>strs[j].charAt(i)){
                    answer++;
                    break;

                }
            }
        }

        return answer;
    }
}
