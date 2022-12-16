package src.Tecent.ArraysAndString;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-23 10:36 Tecent.ArraysAndString - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/23 - the current system date.  10:36 - the current system time.  2022 - the current year.  07 - the current month.  23 - the current day of the month.  10 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L2 {
    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer,Integer> Judge=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(Judge.containsKey(temp)){
                ans[0]=i;
                ans[1]=Judge.get(temp);
            }
            Judge.put(nums[i],i);
        }
        return ans;
    }
}
