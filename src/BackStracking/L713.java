package BackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-25 21:19 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L713 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  21:19 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  21 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L713 {
    //713. 乘积小于 K 的子数组
    //给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
    //
    //
    //示例 1：
    //
    //输入：nums = [10,5,2,6], k = 100
    //输出：8
    //解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
    //需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
    //示例 2：
    //
    //输入：nums = [1,2,3], k = 0
    //输出：0
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();
    int sum=1;
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        BackTracking(nums,k,0);

        return Result.size();
    }

    private void BackTracking(int[] nums,int k,int start){
        if(k==0){

            return;
        }


        if(sum>=k){
            LinkedList<Integer> newTemp=new LinkedList<>(Path);
            newTemp.removeLast();
            Result.add(new ArrayList<>(newTemp));
            return;
        }

        for(int i=start;i<nums.length;i++){


                sum*=nums[i];
                Path.add(nums[i]);
                BackTracking(nums,k,i+1);
                int temp=Path.getLast();
                sum/=temp;
                Path.removeLast();





        }
    }
}
