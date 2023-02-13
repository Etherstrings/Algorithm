package src.tuhu;

/**
 * @author Etherstrings
 * @create 2022-09-28 19:15 tuhu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/28 - the current system date.  19:15 - the current system time.  2022 - the current year.  09 - the current month.  28 - the current day of the month.  19 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int maxIncome (int[] funds) {
        // write code here
        int sum=0;

        for(int i=0;i<funds.length-1;i++){
            int buy=funds[i];
            int now=0;
            for(int j=i+1;j<funds.length;j++){
                if(funds[j]>buy){
                    now=Math.max(funds[j]-buy,now);
                }
            }
            sum=Math.max(now,sum);
        }
        return sum;
    }

}
