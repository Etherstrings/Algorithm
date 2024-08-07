/**
 * @author Etherstrings
 * @create 2022-09-01 13:27 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1475 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/1 - the current system date.  13:27 - the current system time.  2022 - the current year.  09 - the current month.  01 - the current day of the month.  13 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L1475 {
    public int[] finalPrices(int[] prices) {
        for(int i=0;i<prices.length-1;i++){
            int temp=prices[i];
            int now=0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=temp){
                    now=prices[j];
                    break;
                }
            }
            temp=temp-now;
            prices[i]=temp;
        }
        return prices;
    }

}
