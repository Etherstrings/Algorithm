package src.SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-21 17:00 SecondTime.BackTarcking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L90 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/21 - the current system date.  17:00 - the current system time.  2022 - the current year.  08 - the current month.  21 - the current day of the month.  17 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L90 {
    //不可以重复取

    //核心为 滤去当前层使用过的
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0||nums==null){
            return ans;
        }
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        Backtarcking(nums,used,0);
        return ans;
    }

    void Backtarcking(int[] nums,boolean[] used,int startindex){
        ans.add(new ArrayList<>(Path));
        if(startindex>=nums.length){
            return;
        }
        //1 2 2
        //第一次进入
        //第一个取2和第二个取2实际上是一个
        for(int i=startindex;i<nums.length;i++){
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 而我们要对同一树层使用过的元素进行跳过
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
                continue;
            }
            used[i]=true;
            Path.add(nums[i]);
            Backtarcking(nums,used,i+1);
            Path.removeLast();
            used[i]=false;
        }

    }

}
