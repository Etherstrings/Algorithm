import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-17 22:28 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L215 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/17 - the current system date.  22:28 - the current system time.  2022 - the current year.  06 - the current month.  17 - the current day of the month.  22 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L215 {
    //215. 数组中的第K个最大元素
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //
    //
    //
    //示例 1:
    //
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //示例 2:
    //
    //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    //输出: 4
    //
    //
    //提示：
    //
    //1 <= k <= nums.length <= 104
    //-104 <= nums[i] <= 104
    public int findKthLargest(int[] nums, int k) {
        Set<Integer> temp=new HashSet<>();
        for (int num:nums){
            temp.add(num);
        }
        ArrayList<Integer> temparr=new ArrayList<>();
        for(Integer a:temp){
            temparr.add(a);
        }
        Collections.sort(temparr);
        return temparr.get(temparr.size()-k);
    }

    public int findKthLargest1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
