package src;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-06-19 15:24 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L219 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  15:24 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  15 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L219 {

    //219. 存在重复元素 II
    //给你一个整数数组 nums 和一个整数 k
    // 判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
    // 如果存在，返回 true ；否则，返回 false 。

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> Judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(Judge.containsKey(nums[i])){
                //有
                if(i-Judge.get(nums[i])<=k){
                    return true;
                }
            }
                //没有
                Judge.put(nums[i],i);

        }
        return false;

    }
}
