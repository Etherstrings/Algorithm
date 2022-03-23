package Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-03-14 22:59 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  SL56 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/14 - the current system date.  22:59 - the current system time.  2022 - the current year.  03 - the current month.  14 - the current day of the month.  22 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class SL56 {
    //剑指 Offer 56 - II. 数组中数字出现的次数 II
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [3,4,3,3]
    //输出：4
    //示例 2：
    //
    //输入：nums = [9,1,7,9,7,9,7]
    //输出：1
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(judge.containsKey(nums[i])){
                judge.put(nums[i],judge.get(nums[i])+1);
            }else {
                judge.put(nums[i],1);
            }
        }

        int i=0;

        for(Integer key:judge.keySet()){
            if(judge.get(key)==1){
                i=key;
            }
        }

        return i;
    }
}
