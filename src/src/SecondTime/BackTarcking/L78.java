package src.SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-21 16:40 SecondTime.BackTarcking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L78 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/21 - the current system date.  16:40 - the current system time.  2022 - the current year.  08 - the current month.  21 - the current day of the month.  16 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L78 {
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //互不相同的数组里
        //挨个取值
        if(nums==null||nums.length==0){
            return ans;
        }
        BackTarcking(nums,0);
        return ans;
    }


    void BackTarcking(int[] nums,int startindex){
        //挨个作为开头 作为子集
        //每一个进入的都是子集 都要计入
        ans.add(new ArrayList<>(Path));
        if(startindex>=nums.length){
            //取到头了 终止
            return;
        }

        for(int i=startindex;i<nums.length;i++){
            Path.add(nums[i]);
            BackTarcking(nums,i+1);
            Path.removeLast();
        }

    }

}
