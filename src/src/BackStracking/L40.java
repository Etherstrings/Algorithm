package src.BackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-12 23:49 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L40 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/12 - the current system date.  23:49 - the current system time.  2022 - the current year.  05 - the current month.  12 - the current day of the month.  23 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L40 {
    //40. 组合总和 II
    //给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的每个数字在每个组合中只能使用 一次 。
    //
    //注意：解集不能包含重复的组合。
    //
    //
    //
    //示例 1:
    //
    //输入: candidates = [10,1,2,7,6,1,5], target = 8,
    //输出:
    //[
    //[1,1,6],
    //[1,2,5],
    //[1,7],
    //[2,6]
    //]
    //示例 2:
    //
    //输入: candidates = [2,5,2,1,2], target = 5,
    //输出:
    //[
    //[1,2,2],
    //[5]
    //]
    //
    //
    //提示:
    //
    //1 <= candidates.length <= 100
    //1 <= candidates[i] <= 50
    //1 <= target <= 30
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        BackTracking(candidates,target,0);
        return Result;
    }

    private void BackTracking(int[] candidates,int target,int index){
        if(sum==target){
            Result.add(new ArrayList<>(Path));
            return;
        }


        for(int i=index;i<candidates.length&&sum+candidates[i]<=target;i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }





            sum+=candidates[i];
            Path.add(candidates[i]);
            BackTracking(candidates,target,i+1);
            int temp=Path.getLast();
            sum-=temp;
            Path.removeLast();
        }

    }




}
