package SecondTime.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-07-28 22:44 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L209 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  22:44 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  22 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        //双指针
        int left=0;
        int size=Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                size=Math.min(right-left+1,size);
                sum-=nums[left];
                left++;
            }
        }
        return size;
    }
}
