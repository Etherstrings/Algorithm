package src.SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-21 17:39 SecondTime.BackTarcking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L491 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/21 - the current system date.  17:39 - the current system time.  2022 - the current year.  08 - the current month.  21 - the current day of the month.  17 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length==0||nums==null){
            return ans;
        }
        Arrays.sort(nums);

        BackTarcking(nums,0);
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    void BackTarcking(int[] nums,int startindex){
        if(Path.size()>1){
            ans.add(new ArrayList<>(Path));
        }
        if(startindex>=nums.length){
            return;
        }
        int[] used = new int[201];
        for(int i=startindex;i<nums.length;i++){
            //判断当前加上去是不是还是增加的
            if (used[nums[i] + 100] == 1) continue;
            if(Path.size()>=1){
                int temp=Path.getLast();
                if(temp>nums[i]){
                    continue;
                }
            }
            used[nums[i] + 100] = 1;
            Path.add(nums[i]);
            BackTarcking(nums,i+1);
            Path.removeLast();

        }

    }
}
