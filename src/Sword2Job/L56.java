package Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-03-14 22:47 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L56 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/14 - the current system date.  22:47 - the current system time.  2022 - the current year.  03 - the current month.  14 - the current day of the month.  22 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L56 {
    //剑指 Offer 56 - I. 数组中数字出现的次数
    //一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,1,4,6]
    //输出：[1,6] 或 [6,1]
    //示例 2：
    //
    //输入：nums = [1,2,10,4,1,4,3,3]
    //输出：[2,10] 或 [10,2]
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(judge.containsKey(nums[i])){
                judge.put(nums[i],2);
            }else {
                judge.put(nums[i],1);
            }
        }

        int[] answer=new int[2];
        int i=0;

        for(Integer key:judge.keySet()){
            if(judge.get(key)==1){
                answer[i]=key;
                i++;
            }
        }

        return answer;
    }
}
