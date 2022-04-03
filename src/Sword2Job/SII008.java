package Sword2Job;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-04-03 23:12 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII008 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/3 - the current system date.  23:12 - the current system time.  2022 - the current year.  04 - the current month.  03 - the current day of the month.  23 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII008 {
    //剑指 Offer II 008. 和大于等于 target 的最短子数组
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //
    //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    //
    //
    //
    //示例 1：
    //
    //输入：target = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    //示例 2：
    //
    //输入：target = 4, nums = [1,4,4]
    //输出：1
    //示例 3：
    //
    //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    //输出：0
    public int minSubArrayLen(int target, int[] nums) {
        int slow=0;
        int sum=0;

        ArrayList<Integer> answer=new ArrayList<>();
        for(int fast=0;fast<nums.length;fast++){
            sum+=nums[fast];
            while(sum>=target){
                answer.add(fast-slow+1);

                sum-=nums[slow];
                slow++;
            }
        }

        if(answer.isEmpty()){
            return 0;
        }
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer t1=(Integer)o1;
                Integer t2=(Integer)o2;
                return t1.compareTo(t2);
            }
        };
        answer.sort(com);
        int answer1= (int) answer.get(0);
        return answer1;
    }
}
