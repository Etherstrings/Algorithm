package HASH;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2023-02-24 14:44 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2357 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/24 - the current system date.  14:44 - the current system time.  2023 - the current year.  02 - the current month.  24 - the current day of the month.  14 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2357 {
    //2357. 使数组中所有元素都等于零
    //给你一个非负整数数组 nums 。在一步操作中，你必须：
    //
    //选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
    //nums 中的每个正整数都减去 x。
    //返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,5,0,3,5]
    //输出：3
    //解释：
    //第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
    //第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
    //第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。
    //示例 2：
    //
    //输入：nums = [0]
    //输出：0
    //解释：nums 中的每个元素都已经是 0 ，所以不需要执行任何操作。
    public int minimumOperations(int[] nums) {
        Set<Integer> st=new HashSet<>();
        for(int n:nums){
            st.add(n);
        }
        if(st.size()==1&&st.size()==0){
            return 0;
        }
        if(st.contains(0)){
            return st.size()-1;
        }
        return st.size();
    }
}
