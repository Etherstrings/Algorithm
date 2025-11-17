package TwoPoint;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-05-13 14:08 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2441 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/13 - the current system date.  14:08 - the current system time.  2023 - the current year.  05 - the current month.  13 - the current day of the month.  14 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int slow=0;
        int fast=nums.length-1;
        int ans=Integer.MIN_VALUE;
        while(slow<fast){
            int left=nums[slow];
            int right=nums[fast];
            if(Math.abs(left)==Math.abs(right)){
                if(right>0&&left<0){
                    ans=Math.max(ans,right);
                }

                slow++;
                fast--;
                continue;
            }
            if(Math.abs(left)>Math.abs(right)){
                slow++;
                continue;
            }
            if(Math.abs(left)<Math.abs(right)){
                fast--;
                continue;
            }

        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}
