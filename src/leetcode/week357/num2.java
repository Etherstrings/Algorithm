package leetcode.week357;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-08-16 16:47 leetcode.week357 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/16 - the current system date.  16:47 - the current system time.  2023 - the current year.  08 - the current month.  16 - the current day of the month.  16 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //倒着推
    //1 1 1 1 1 2 2 1 1 1 1 1
    //4
    //可以随便从前后逐渐进行拆分，也就是说只要有两个相邻的大于等于m就可以
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size()<=2) {
            return true;
        }
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i)+nums.get(i+1)>=m){
                return true;
            }
        }
        return false;
    }
}
