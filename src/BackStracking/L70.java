package BackStracking;

/**
 * @author Etherstrings
 * @create 2022-06-10 10:41 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L70 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/10 - the current system date.  10:41 - the current system time.  2022 - the current year.  06 - the current month.  10 - the current day of the month.  10 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L70 {

    int howmany=0;
    public int climbStairs(int n) {
        BackTarcking(n,0);
        return howmany;
    }

    void BackTarcking(int n,int result){
        if(n==1){
            howmany+=1;
            return;
        }
        if(n==2){
            howmany+=2;
            return;
        }
        if(result==n){
            howmany++;
            return;
        }

        for(int i=1;i<=2;i++){
            if(result<n){
                result+=i;
                BackTarcking(n,result);
                result-=i;
            }
        }


    }

}
