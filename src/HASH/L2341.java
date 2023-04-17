package HASH;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2023-02-16 11:26 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2341 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  11:26 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  11 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2341 {
    //2341. 数组能形成多少数对
    //给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
    //
    //从 nums 选出 两个 相等的 整数
    //从 nums 中移除这两个整数，形成一个 数对
    //请你在 nums 上多次执行此操作直到无法继续执行。
    //
    //返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,3,2,1,3,2,2]
    //输出：[3,1]
    //解释：
    //nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
    //nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
    //nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
    //无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
    //示例 2：
    //
    //输入：nums = [1,1]
    //输出：[1,0]
    //解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
    //无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
    //示例 3：
    //
    //输入：nums = [0]
    //输出：[0,1]
    //解释：无法形成数对，nums 中剩下 1 个数字。
    public static int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        int ans[]=new int[2];
        ans[0]=0;
        ans[1]=0;
        for(int num:map.keySet()){
            if(map.get(num)%2==1){
                ans[0]+=map.get(num)%2;
                ans[1]++;
            }else {
                ans[0]+=map.get(num)%2;
            }
        }
        return ans;
    }
}
