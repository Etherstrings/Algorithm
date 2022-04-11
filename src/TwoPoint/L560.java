package TwoPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-04-06 10:11 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L560 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/6 - the current system date.  10:11 - the current system time.  2022 - the current year.  04 - the current month.  06 - the current day of the month.  10 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L560 {
    //560. 和为 K 的子数组
    //给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,1,1], k = 2
    //输出：2
    //示例 2：
    //
    //输入：nums = [1,2,3], k = 3
    //输出：2

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        map.put(0,1);

        int sum=0,ret=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                ret+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return ret;
    }


    //不能用滑动窗口 错的
    public int subarraySum1(int[] nums, int k) {
        //思路
        //我觉得是滑动窗口方法
        //不能先排序
        int slow=0;
        int sum= 0;
        int many=0;

        if(nums==null){
            return 0;
        }

        if(nums.length==0){
            return 0;
        }

        for(int fast=0;fast<nums.length;fast++){
            sum+=nums[fast];
            if(sum==k){
                many++;
                slow++;
            }
        }
        return many;
    }
}
