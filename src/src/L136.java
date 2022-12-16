package src;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-06-14 19:29 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L136 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/14 - the current system date.  19:29 - the current system time.  2022 - the current year.  06 - the current month.  14 - the current day of the month.  19 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L136 {
    //136. 只出现一次的数字
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //
    //说明：
    //
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //示例 1:
    //
    //输入: [2,2,1]
    //输出: 1
    //示例 2:
    //
    //输入: [4,1,2,1,2]
    //输出: 4
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> Judge = new HashMap<>();
        for(int a:nums){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }
        int asnwer=-1;
        for(Integer b:Judge.keySet()){
            if(Judge.get(b)==1){
                asnwer=b;
                break;
            }
        }
        return asnwer;
    }
}
