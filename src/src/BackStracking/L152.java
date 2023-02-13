package src.BackStracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-09 18:49 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L152 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/9 - the current system date.  18:49 - the current system time.  2022 - the current year.  07 - the current month.  09 - the current day of the month.  18 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L152 {
    //152. 乘积最大子数组
    //给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    //
    //测试用例的答案是一个 32-位 整数。
    //
    //子数组 是数组的连续子序列。
    //
    //

    //1.遍历
    //2.递归
    List<Integer> ans=new ArrayList<>();
    public int maxProduct(int[] nums) {
        Backtarcking(nums,0);
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }

    //横向怎么循环？
    void Backtarcking(int[] nums,int start){
        if(start==nums.length){
            return;
        }

        for(int i=start;i<nums.length;i++){
            int sum=1;
            for(int j=start;j<=i;j++){
                sum=sum*nums[j];
            }
            ans.add(sum);
        }

        Backtarcking(nums,start+1);
    }
}
