package src.leetcode.week321;

/**
 * @author Etherstrings
 * @create 2022-11-27 21:59 leetcode.week321 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6245 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/27 - the current system date.  21:59 - the current system time.  2022 - the current year.  11 - the current month.  27 - the current day of the month.  21 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L6245 {
    public int pivotInteger(int n) {
        if(n==1){
            return 1;
        }
        int sum=0;
        //从1加到n
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            boolean flag=false;
            int temp=0;
            for(int j=1;j<=i;j++){
                temp+=j;
            }
            for(int j=n;j>=i;j--){
                temp-=j;
            }
            if(temp==0){
                ans=i;
                break;
            }
        }
        return ans;
    }
}
