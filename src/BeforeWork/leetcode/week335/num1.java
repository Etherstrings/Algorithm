package leetcode.week335;

/**
 * @author Etherstrings
 * @create 2023-03-05 10:28 Leetcode.week335 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/5 - the current system date.  10:28 - the current system time.  2023 - the current year.  03 - the current month.  05 - the current day of the month.  10 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int passThePillow(int n, int time) {
        if(n==1){
            return n;
        }
        int now=1;
        int round=n-1;
        if((time/round)%2==0){
            //向右
            if(time%round==0){
                return n;
            }else {
                return time%round+1;
            }
        }else {
            //向左
            if(time%round==0){
                return 1;
            }else {
                return n-(round%time);
            }
        }
    }
}
