package TwoTo2;

/**
 * @author Etherstrings
 * @create 2022-07-27 20:51 TwoTo2 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L704 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  20:51 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  20 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L704 {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        //左闭右开的区间
        while(left<right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}
