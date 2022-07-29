package SecondTime.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-07-27 21:09 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L27 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  21:09 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  21 - the current hour.  09 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L27 {
    //双指针
    //在数组中删除目标元素
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){

                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
