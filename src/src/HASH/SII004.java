package src.HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-04-01 13:22 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII004 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/1 - the current system date.  13:22 - the current system time.  2022 - the current year.  04 - the current month.  01 - the current day of the month.  13 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII004 {
    //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    //
    // 
    //
    //示例 1：
    //
    //输入：nums = [2,2,3,2]
    //输出：3
    //示例 2：
    //
    //输入：nums = [0,1,0,1,0,1,100]
    //输出：100
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/WGki4K
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(judge.containsKey(nums[i])){
                judge.put(nums[i],judge.get(nums[i])+1);
            }else {
                judge.put(nums[i],1);
            }
        }
        int[] answer=new int[1];
        for(Map.Entry entry: judge.entrySet()){
            if((Integer) entry.getValue()==1){
                answer[0]= (int)entry.getKey();
            }
        }
        return answer[0];
    }
}
