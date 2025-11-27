import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-06-14 19:42 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L137 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/14 - the current system date.  19:42 - the current system time.  2022 - the current year.  06 - the current month.  14 - the current day of the month.  19 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L137 {
    //137. 只出现一次的数字 II
    //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,2,3,2]
    //输出：3
    //示例 2：
    //
    //输入：nums = [0,1,0,1,0,1,99]
    //输出：99
    //
    //
    //提示：
    //
    //1 <= nums.length <= 3 * 104
    //-231 <= nums[i] <= 231 - 1
    //nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
    //
    //
    //进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=3){
            if(nums[i]!=nums[i+2]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

}
