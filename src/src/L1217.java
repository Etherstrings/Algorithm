package src;

/**
 * @author Etherstrings
 * @create 2022-07-09 10:08 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1217 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/9 - the current system date.  10:08 - the current system time.  2022 - the current year.  07 - the current month.  09 - the current day of the month.  10 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1217 {

    public int minCostToMoveChips(int[] position) {
        int a=0;
        int b=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                a++;
            }else {
                b++;
            }
        }
        return Math.min(a,b);
    }
}
