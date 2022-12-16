package src.Sword2Job;

/**
 * @author Etherstrings
 * @create 2022-03-14 23:03 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L57 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/14 - the current system date.  23:03 - the current system time.  2022 - the current year.  03 - the current month.  14 - the current day of the month.  23 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L57 {
    //剑指 Offer 57. 和为s的两个数字
    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,7,11,15], target = 9
    //输出：[2,7] 或者 [7,2]
    //示例 2：
    //
    //输入：nums = [10,26,30,31,47,60], target = 40
    //输出：[10,30] 或者 [30,10]

    //双指针
    public int[] twoSum(int[] nums, int target) {
        int[] answer=new int[2];

        int left=0;
        int right=nums.length-1;
        while (left<right){
            if(nums[left]+nums[right]==target){
                answer[0]=nums[left];
                answer[1]=nums[right];
                return answer;
            }else if(nums[left]+nums[right]<target){
                left++;
            }else if(nums[left]+nums[right]>target){
                right--;
            }
        }
        return new int[0];
    }
}
