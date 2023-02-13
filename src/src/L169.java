package src;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-06-15 23:13 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L169 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/15 - the current system date.  23:13 - the current system time.  2022 - the current year.  06 - the current month.  15 - the current day of the month.  23 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L169 {

    //169. 多数元素
    //给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [3,2,3]
    //输出：3
    //示例 2：
    //
    //输入：nums = [2,2,1,1,1,2,2]
    //输出：2
    //
    //
    //提示：
    //n == nums.length
    //1 <= n <= 5 * 104
    //-109 <= nums[i] <= 109
    //
    //
    //进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);


        int temp=nums[0];
        int half=nums.length/2;
        int many=1;
        int answer=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==temp){
                many++;
                if(many>half){
                    answer=nums[i];
                    break;
                }
            }else {
                temp=nums[i];
                many=1;
            }
        }
        return answer;
    }
}
