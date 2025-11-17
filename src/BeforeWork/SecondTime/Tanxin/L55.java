package SecondTime.Tanxin;

/**
 * @author Etherstrings
 * @create 2022-08-24 18:34 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L55 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  18:34 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  18 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L55 {
    public boolean canJump(int[] nums){
        //记录当前的最大跳跃地
        //没移动一次更新每次都跳最大的
        int now=0;
        //核心在这里 只能在能到达的区域内更新
        for(int i=0;i<now;i++){
            //当前位置可以到到的range
            int temp=i+nums[i];
            if(temp>=now){
                now=temp;
            }
        }
        if(now>=nums.length-1){
            return true;
        }
        return false;
    }
}
