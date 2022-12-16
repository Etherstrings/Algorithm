package src;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-29 16:56 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1470 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  16:56 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  16 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1470 {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> left=new ArrayList<>();
        for(int i=0;i<n;i++){
            left.add(nums[i]);
        }

        List<Integer> right=new ArrayList<>();
        for(int i=n;i<nums.length;i++){
            right.add(nums[i]);
        }

        for(int i=0;i<n;i++){
            nums[i*2]=left.get(i);
            nums[i*2+1]=right.get(i);
        }
        return nums;
    }
}
