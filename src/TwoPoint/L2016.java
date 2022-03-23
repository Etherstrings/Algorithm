package TwoPoint;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author Etherstrings
 * @create 2022-02-27 22:24 TwoPoint - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L2016 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/27 - the current system date.  22:24 - the current system time.  2022 - the current year.  02 - the current month.  27 - the current day of the month.  22 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2016 {
    //2016. 增量元素之间的最大差值
    //给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
    //
    //返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
    public int maximumDifference(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int diff=0;
        boolean flag=false;

        while(right>left){
            if (nums[left] > nums[right]) {
                left++;

            }else if(nums[left]==nums[right]){
                left++;

            }else if(nums[left]<nums[right]){
                int change=nums[right]-nums[left];
                diff=Math.max(change, diff);
                right--;
                flag=true;
            }
        }
        if(flag==false){
            return -1;
        }
        return diff;
    }

    public int maximumDifference1(int[] nums){
        int ans=-1;
        int min=nums[0];

        for(int i=1;i<nums.length;i++){
            if(min>=nums[i]){
                min=nums[i];
                continue;
            }

            ans=Math.max(ans,nums[i]-min);
        }

        return ans;
    }
}
