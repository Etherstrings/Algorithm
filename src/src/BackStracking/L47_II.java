package src.BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-23 16:32 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L47_II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  16:32 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  16 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L47_II {
    //47. 全排列 II
    //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,1,2]
    //输出：
    //[[1,1,2],
    // [1,2,1],
    // [2,1,1]]
    //示例 2：
    //
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //
    //
    //提示：
    //
    //1 <= nums.length <= 8
    //-10 <= nums[i] <= 10
    List<List<Integer>> Result=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] Used=new boolean[nums.length];
        BackTracking(nums,Used);
        return Result;
    }

    private void BackTracking(int[] nums,boolean[] Used){
        if(Path.size()== nums.length){
            Result.add(new ArrayList<>(Path));
            return;
        }

        for(int i=0;i< nums.length;i++){
            //判断 当前
            //1 2 2
            //是不是取到了第二个2
            //如果
            if(i>0&&nums[i]==nums[i-1]&&Used[i-1]==false){
                continue;
            }

            //判断当前的是不是用过了？
            if(Used[i]==false){
                Used[i]=true;
                Path.add(nums[i]);
                BackTracking(nums, Used);
                Used[i]=false;
                Path.removeLast();
            }

        }
    }
}
