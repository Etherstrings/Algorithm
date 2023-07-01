package leetcode.week350;

/**
 * @author Etherstrings
 * @create 2023-06-18 10:32 leetcode.week350 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/18 - the current system date.  10:32 - the current system time.  2023 - the current year.  06 - the current month.  18 - the current day of the month.  10 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int len=0;
        while(mainTank>0){
            if(mainTank>=5){
                //消耗5
                len+=50;
                mainTank-=5;
                if(additionalTank>0){
                    additionalTank-=1;
                    mainTank+=1;
                }
            }else {
                len+=mainTank*10;
                mainTank=0;
            }
        }
        return len;
    }
}
