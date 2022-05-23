package BackStracking;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-23 11:30 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L78 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  11:30 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  11 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L78 {
    //78. 子集
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    //
    //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //示例 2：
    //
    //输入：nums = [0]
    //输出：[[],[0]]
    //
    //
    //提示：
    //
    //1 <= nums.length <= 10
    //-10 <= nums[i] <= 10
    //nums 中的所有元素 互不相同


    //思路
        //全局变量 Path+Result
        //遍历什么 从nums中逐步取
        //递归什么 不取前面的 只取后面的

    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            Result.add(new ArrayList<>(Path));
            return Result;
        }
        BackTracking(nums,0);
        return Result;
    }

    private void BackTracking(int[] nums,int startindex){
        Result.add(new ArrayList<>(Path));
        //终止条件
        if(startindex>=nums.length){
            return;
        }
        //单层的逻辑是什么？
        for(int i=startindex;i<nums.length;i++){
            Path.add(nums[i]);
            BackTracking(nums,i+1);
            Path.removeLast();
        }
    }
}
