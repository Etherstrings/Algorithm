package src.Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-03-08 9:30 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  s03 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  9:30 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  09 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class s03 {
    //找出数组中重复的数字。
    //
    //
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    //
    //示例 1：
    //
    //输入：
    //[2, 3, 1, 0, 2, 5, 3]
    //输出：2 或 3
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int findRepeatNumber(int[] nums) {
    Map<Integer,Integer> judgement=new HashMap<>();
    int answer=0;
    for(int i=0;i<nums.length;i++){
        if(judgement.containsKey(nums[i])){

            answer=nums[i];
            break;
        }else{
            judgement.put(nums[i],i);
        }
    }

    return answer;
}
}
