package SecondTime.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-08-13 13:07 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L724 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/13 - the current system date.  13:07 - the current system time.  2022 - the current year.  08 - the current month.  13 - the current day of the month.  13 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L724 {
    //724. 寻找数组的中心下标
    //给你一个整数数组 nums ，请计算数组的 中心下标 。
    //
    //数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
    //
    //如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
    //
    //如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1, 7, 3, 6, 5, 6]
    //输出：3
    //解释：
    //中心下标是 3 。
    //左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
    //右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
    //示例 2：
    //
    //输入：nums = [1, 2, 3]
    //输出：-1
    //解释：
    //数组中不存在满足此条件的中心下标。
    //示例 3：
    //
    //输入：nums = [2, 1, -1]
    //输出：0
    //解释：
    //中心下标是 0 。
    //左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
    //右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 总和
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum + nums[i]; // leftSum 里面已经有 nums[i]，多减了一次，所以加上
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1; // 不存在
    }
}
