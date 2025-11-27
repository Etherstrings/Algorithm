package BackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-23 15:08 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L90_II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  15:08 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  15 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L90_II {
    //90. 子集 II
    //给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    //
    //解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,2]
    //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
    //示例 2：
    //
    //输入：nums = [0]
    //输出：[[],[0]]

    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //核心思路是什么？
        //同一层 不取相同的
        Arrays.sort(nums);
        BackTracking(nums,0);
        return Result;
    }

    private void BackTracking(int[] nums,int index){
        Result.add(new ArrayList<>(Path));
        if(index>=nums.length){
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }

            //剩下的都不是重复的了
            Path.add(nums[i]);
            BackTracking(nums,i+1);
            Path.removeLast();
        }
    }
}
