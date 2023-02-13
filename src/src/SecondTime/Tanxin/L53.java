package src.SecondTime.Tanxin;

/**
 * @author Etherstrings
 * @create 2022-08-24 16:38 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L53 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  16:38 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  16 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L53 {
    public int maxSubArray(int[] nums){
        //当前连续和<0 舍弃 再加就是损耗
        if(nums.length==1){
            return nums[0];
        }
        int count=0;
        int sum=Integer.MIN_VALUE;

        for(int a:nums){
            count+=a;
            sum=Math.max(count,sum);
            if(count<0){
                count=0;
            }
        }
        return sum;
    }
}
