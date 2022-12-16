package src;

/**
 * @author Etherstrings
 * @create 2022-06-07 22:01 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L33 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/7 - the current system date.  22:01 - the current system time.  2022 - the current year.  06 - the current month.  07 - the current day of the month.  22 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L33 {
    //33. 搜索旋转排序数组
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    //
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
    //
    //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    //示例 2：
    //
    //输入：nums = [4,5,6,7,0,1,2], target = 3
    //输出：-1
    //示例 3：
    //
    //输入：nums = [1], target = 0
    //输出：-1
    //
    //
    //提示：
    //
    //1 <= nums.length <= 5000
    //-10^4 <= nums[i] <= 10^4
    //nums 中的每个值都 独一无二
    //题目数据保证 nums 在预先未知的某个下标上进行了旋转
    //-10^4 <= target <= 10^4
    //
    //
    //进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
    public int search(int[] nums, int target) {

        //没怎么看明白题目意思
        //当作查找是否存在来看了
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
