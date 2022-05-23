package BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-11 19:38 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L39 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/11 - the current system date.  19:38 - the current system time.  2022 - the current year.  05 - the current month.  11 - the current day of the month.  19 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L39 {
    //39. 组合总和
    //给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    //
    //candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    //
    //对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    //
    //
    //
    //示例 1：
    //
    //输入：candidates = [2,3,6,7], target = 7
    //输出：[[2,2,3],[7]]
    //解释：
    //2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    //7 也是一个候选， 7 = 7 。
    //仅有这两种组合。
    //示例 2：
    //
    //输入: candidates = [2,3,5], target = 8
    //输出: [[2,2,2,2],[2,3,3],[3,5]]
    //示例 3：
    //
    //输入: candidates = [2], target = 1
    //输出: []


    //维护全局变量

    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        BackStracking(candidates,target,0,0);
        return Result;
    }

    //回溯的方法
    //回溯的参数是什么？
    private void BackStracking(int[] candidates, int target,int index,int sum){
        if(sum>target){
            return;
        }
        if(sum==target){
            Result.add(new ArrayList<>(Path));
            return;
        }


        //先写未减枝操作
        for(int i=index;i<candidates.length;i++){
            sum+=candidates[i];
            Path.add(candidates[i]);

            BackStracking(candidates,target,i,sum);
            sum-=candidates[i];
            Path.removeLast();
        }
    }

}
