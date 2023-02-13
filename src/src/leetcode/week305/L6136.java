package src.leetcode.week305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-08-07 15:23 leetcode.week305 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6136 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/7 - the current system date.  15:23 - the current system time.  2022 - the current year.  08 - the current month.  07 - the current day of the month.  15 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6136 {
    //6136. 算术三元组的数目 显示英文描述
    //通过的用户数6073
    //尝试过的用户数6132
    //用户总通过次数6218
    //用户总提交次数7199
    //题目难度Easy
    //给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
    //
    //i < j < k ，
    //nums[j] - nums[i] == diff 且
    //nums[k] - nums[j] == diff
    //返回不同 算术三元组 的数目。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [0,1,4,6,7,10], diff = 3
    //输出：2
    //解释：
    //(1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
    //(2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
    //示例 2：
    //
    //输入：nums = [4,5,6,7,8,9], diff = 2
    //输出：2
    //解释：
    //(0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
    //(1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
    //
    //
    //提示：
    //
    //3 <= nums.length <= 200
    //0 <= nums[i] <= 200
    //1 <= diff <= 50
    //nums 严格 递增
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> Judge=new HashSet<>();
        for(int a:nums){
            Judge.add(a);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(Judge.contains(nums[i]+diff)&& Judge.contains(nums[i]+diff+diff)){
                ans++;
            }
        }
        return ans;
    }
}
