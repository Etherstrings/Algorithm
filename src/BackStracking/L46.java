package BackStracking;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-05-23 16:07 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L46 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  16:07 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  16 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L46 {
    //46. 全排列
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //示例 2：
    //
    //输入：nums = [0,1]
    //输出：[[0,1],[1,0]]
    //示例 3：
    //
    //输入：nums = [1]
    //输出：[[1]]

    //思路
    //回溯
    //返回全排列----多少都要排满
    //挨个取
    //取完深层递归 接着挨个取


    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();
    boolean[] Used;
    public List<List<Integer>> permute(int[] nums) {
        Used=new boolean[nums.length];
        BackTarcking(nums);
        return Result;
    }

    private void BackTarcking(int[] nums){

        //终止的条件？
        if(Path.size()== nums.length){
            Result.add(new ArrayList<>(Path));
            return;
        }


        //单层的顺序
        for(int i=0;i< nums.length;i++){
            //是不是用过了？
            if(Used[i]){
                continue;
            }

            //单层的继续
            Used[i]=true;
            Path.add(nums[i]);
            BackTarcking(nums);
            Used[i]=false;
            Path.removeLast();
        }
    }
}
