package MeiSilu;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-03-10 22:07 MeiSilu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1590 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/10 - the current system date.  22:07 - the current system time.  2023 - the current year.  03 - the current month.  10 - the current day of the month.  22 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1590 {
    public int minSubarray(int[] nums, int p) {
        //笨方法
        //控制滑动窗口
        long sum= Arrays.stream(nums).sum();
        if(sum%p==0){
            return 0;
        }
        boolean flag=false;
        int ans=1;
        while(ans<=nums.length){
            if(flag==true){
                break;
            }
            for(int i=0;i<nums.length-ans;i++){
                long temp=sum;
                for(int j=i;j<i+ans;j++){
                    temp-=nums[j];
                }
                if(temp%p==0){
                    flag=true;
                    break;
                }
            }
        }
        if(flag==false){
            return -1;
        }
        return ans;
    }
}
