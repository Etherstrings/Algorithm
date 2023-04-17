package BackStracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-23 15:34 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L491_Hard - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  15:34 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  15 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L491_Hard {
    List<Integer> Path=new ArrayList<>();
    List<List<Integer>> Result=new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        BackTracking(nums,0);
        return Result;
    }
    private void BackTracking(int[] nums, int start){
        if(Path.size()>1){
            Result.add(new ArrayList<>(Path));
        }
        int[] used = new int[201];
        for(int i=start;i<nums.length;i++){
            if(!Path.isEmpty()&&nums[i]<Path.get(Path.size()-1)
            ||(used[nums[i]+100]==1)){
                continue;
            }

            used[nums[i]+100]=1;
            Path.add(nums[i]);
            BackTracking(nums,i+1);
            Path.remove(Path.size()-1);

        }


    }
}
