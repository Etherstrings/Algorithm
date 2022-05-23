package BackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-13 0:14 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L40_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/13 - the current system date.  0:14 - the current system time.  2022 - the current year.  05 - the current month.  13 - the current day of the month.  00 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L40_1 {

    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> Result=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target ) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort( candidates );
        backTracking( candidates, target, 0 ,0);
        return Result;
    }

    private void backTracking(int[] candidates, int target, int sum,int index) {
        if(sum>target){
            return;
        }
        if(sum==target){
            Result.add(new ArrayList<>(Path));
            return;
        }


        for(int i=index;i<candidates.length;i++){

            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }

            sum+=candidates[i];
            Path.add(candidates[i]);
            backTracking(candidates,target,sum,i+1);
            sum-=candidates[i];
            Path.removeLast();

        }
    }
}
