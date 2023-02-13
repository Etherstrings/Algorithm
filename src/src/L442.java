package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-25 23:17 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L442 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  23:17 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  23 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L442 {
    //442. 数组中重复的数据
    //给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
    //
    //你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,3,2,7,8,2,3,1]
    //输出：[2,3]
    //示例 2：
    //
    //输入：nums = [1,1,2]
    //输出：[1]
    //示例 3：
    //
    //输入：nums = [1]
    //输出：[]
    //
    //
    //提示：
    //
    //n == nums.length
    //1 <= n <= 105
    //1 <= nums[i] <= n
    //nums 中的每个元素出现 一次 或 两次
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int a:nums){
            if(!Judge.containsKey(a)){
                Judge.put(a,1);
            }else {
                Judge.put(a,Judge.get(a)+1);
            }
        }
        List<Integer> Answer=new ArrayList<>();
        for(Integer b:Judge.keySet()){
            if(Judge.get(b)==2){
                Answer.add(b);
            }
        }
        return Answer;
    }
}
