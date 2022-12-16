package src.SecondTime.ArrayList;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-08-13 13:16 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L34 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/13 - the current system date.  13:16 - the current system time.  2022 - the current year.  08 - the current month.  13 - the current day of the month.  13 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L34 {
    //34. 在排序数组中查找元素的第一个和最后一个位置
    //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    //
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //
    //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]
    //示例 2：
    //
    //输入：nums = [5,7,7,8,8,10], target = 6
    //输出：[-1,-1]
    //示例 3：
    //
    //输入：nums = [], target = 0
    //输出：[-1,-1]
    //
    //
    //提示：
    //
    //0 <= nums.length <= 105
    //-109 <= nums[i] <= 109
    //nums 是一个非递减数组
    //-109 <= target <= 109
    //通过次数614,761提交次数1,453,301
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        if(nums.length==0){
            return ans;
        }
        while(left<=right){
            if(nums[left]==nums[right]&&nums[right]==target){
                ans[0]=left;
                ans[1]=right;
                break;
            }
            if(nums[left]!=target){
                left++;
            }
            if(nums[right]!=target){
                right--;
            }
        }
        return ans;
    }
}
