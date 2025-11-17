package leetcode.week298;

/**
 * @author Etherstrings
 * @create 2022-06-19 11:17 leetcode.week298 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L5218 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  11:17 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  11 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L5218 {

    public int minimumNumbers(int num, int k) {
        if(num==0&&k==0){
            return 0;
        }
        if(num<10){
            if(num==k){
                return 1;
            }else if(num<k){
                if(num==0){
                    return 0;
                }
                return -1;
            }else {
                return 0;
            }
        }
        //用k当
        int max=num/10;

        int slow=0;
        int fast=max;
        int ans=0;
        boolean Flag=false;
        for(int i=0;i<max-1;i++){
            for(int j=i+1;j<max;j++){
                if(i*10+k==num){
                    Flag=true;
                    ans++;
                }
                if(j*10+k==num){
                    Flag=true;
                    ans++;
                }
                if(i*10+k+j*10+k==num){
                    Flag=true;
                    ans++;
                }
            }
        }

        if(Flag==false){
            return -1;
        }
        return ans;
    }

}
