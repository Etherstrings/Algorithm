import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-25 20:51 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L581 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/25 - the current system date.  20:51 - the current system time.  2022 - the current year.  06 - the current month.  25 - the current day of the month.  20 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L581 {
    //581. 最短无序连续子数组
    //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //
    //请你找出符合题意的 最短 子数组，并输出它的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,6,4,8,10,9,15]
    //输出：5
    //解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    //示例 2：
    //
    //输入：nums = [1,2,3,4]
    //输出：0
    //示例 3：
    //
    //输入：nums = [1]
    //输出：0
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        List<Integer> Judege=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(temp[i]!=nums[i]){
                Judege.add(i);
            }
        }
        if(Judege.size()==0){
            return 0;
        }
        return Judege.get(Judege.size()-1)- Judege.get(0)+1;
    }

}
