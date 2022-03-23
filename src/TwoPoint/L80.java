package TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-03-09 9:42 TwoPoint - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L80 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/9 - the current system date.  9:42 - the current system time.  2022 - the current year.  03 - the current month.  09 - the current day of the month.  09 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */

//80. 删除有序数组中的重复项 II
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
//说明：
//
//为什么返回数值是整数，但输出的答案是数组呢？
//
//请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的
public class L80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int slow=2;int fast=2;
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
