package BackStracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-25 10:44 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L491 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  10:44 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  10 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */

public class L491 {
    //491. 递增子序列
    //给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，
    // 递增子序列中至少有两个元素
    // 你可以按 任意顺序 返回答案。
    //
    //数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,6,7,7]
    //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    //示例 2：
    //
    //输入：nums = [4,4,3,2,1]
    //输出：[[4,4]]


    //思路
        //还是回溯
        //能动原始数组吗？---不能动 也不能排序

    //终止条件是什么？
        //找到最后一位或者当前位小于前一位
        //递增的子序列 最少有两个元素

    //传递条件 数组+startindex

    //单层的逻辑
        //判断是否用过？
        //一层的重复元素 不能再重新取 不能再度进入

    //Path+Result
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        BackTarcking(nums,0);
        return Result;

    }

    private void BackTarcking(int[] nums,int start){
        if(Path.size()>1){
            Result.add(new ArrayList<>(Path));
        }

        HashMap<Integer,Integer> Used=new HashMap<>();

        for(int i=start;i< nums.length;i++){

            //如果取到的数 已经比最后一个数小
            //跳过了
            if(!Path.isEmpty()&&Path.getLast()>nums[i]){
                continue;
            }

            //判断当层元素是不是用过了
            if(Used.getOrDefault(nums[i],0)>=1){
                continue;
            }


            //写这一层的具体
            Path.add(nums[i]);

            //说这个数已经用过了
            Used.put(nums[i],Used.getOrDefault(nums[i],0)+1);
            //递归往下传 开始下个数的递归
            BackTarcking(nums,i+1);

            //回溯
            Path.removeLast();
        }


    }

}
