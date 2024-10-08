package SecondTime.Tanxin;

/**
 * @author Etherstrings
 * @create 2022-08-24 16:55 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L122 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  16:55 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  16 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L122 {
    public int maxProfit(int[] prices){
        //如果今天卖 昨天买赚的话
        //就可以收集今天的利润
        int result=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                result+=prices[i]-prices[i-1];
            }
        }
        return result;
    }
}
