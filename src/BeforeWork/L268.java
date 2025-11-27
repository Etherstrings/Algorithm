/**
 * @author Etherstrings
 * @create 2022-06-19 15:48 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L268 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  15:48 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  15 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L268 {
    //268. 丢失的数字
    //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [3,0,1]
    //输出：2
    //解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    //示例 2：
    //
    //输入：nums = [0,1]
    //输出：2
    //解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    //示例 3：
    //
    //输入：nums = [9,6,4,2,3,5,7,0,1]
    //输出：8
    //解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
    //示例 4：
    //
    //输入：nums = [0]
    //输出：1
    //解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
    //
    //
    //提示：
    //
    //n == nums.length
    //1 <= n <= 104
    //0 <= nums[i] <= n
    //nums 中的所有数字都 独一无二
    public int missingNumber(int[] nums) {
        //数组不重复

        //n为nums的长度

        int n=nums.length;

        //遍历数组 找到从0-n 少了哪一个数
        int sum=0;
        for(int i=0;i<n+1;i++){
            sum+=i;
        }
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
}
