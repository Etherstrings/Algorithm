package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-06-17 22:36 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L217 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/17 - the current system date.  22:36 - the current system time.  2022 - the current year.  06 - the current month.  17 - the current day of the month.  22 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L217 {
    //217. 存在重复元素
    //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3,1]
    //输出：true
    //示例 2：
    //
    //输入：nums = [1,2,3,4]
    //输出：false
    //示例 3：
    //
    //输入：nums = [1,1,1,3,3,4,3,2,4,2]
    //输出：true
    //
    //
    //提示：
    //
    //1 <= nums.length <= 105
    //-109 <= nums[i] <= 109
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> Seen=new HashSet<>();
        Arrays.sort(nums);
        int num=0;
        for(int a:nums){
            if(Seen.contains(a)){
                num++;
            }else {
                num=0;
                Seen.add(a);
                num++;
            }
            if(num>=2){
                return true;
            }
        }
        return false;
    }

}
