package SecondTime.ArrayList;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-08-13 13:26 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L922 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/13 - the current system date.  13:26 - the current system time.  2022 - the current year.  08 - the current month.  13 - the current day of the month.  13 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L922 {
    //922. 按奇偶排序数组 II
    //给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
    //
    //对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
    //
    //你可以返回 任何满足上述条件的数组作为答案 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,2,5,7]
    //输出：[4,5,2,7]
    //解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
    //示例 2：
    //
    //输入：nums = [2,3]
    //输出：[2,3]
    //
    //
    //提示：
    //
    //2 <= nums.length <= 2 * 104
    //nums.length 是偶数
    //nums 中一半是偶数
    //0 <= nums[i] <= 1000
    public int[] sortArrayByParityII(int[] nums) {
        Stack<Integer> OU=new Stack<>();
        Stack<Integer> JI=new Stack<>();
        for(int i:nums){
            if(i%2==0){
                OU.push(i);
            }else {
                JI.push(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=OU.pop();
            }else {
                nums[i]=JI.pop();
            }
        }
        return nums;
    }
}
