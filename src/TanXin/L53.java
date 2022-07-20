package TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-12 21:17 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L53 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/12 - the current system date.  21:17 - the current system time.  2022 - the current year.  07 - the current month.  12 - the current day of the month.  21 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L53 {
    //贪心
    //53. 最大子数组和
    //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //子数组 是数组中的一个连续部分。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    //输出：6
    //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    //示例 2：
    //
    //输入：nums = [1]
    //输出：1
    //示例 3：
    //
    //输入：nums = [5,4,-1,7,8]
    //输出：23
    public int maxSubArray(int[] nums) {
        //贪心 思路是什么？
        //就是一旦当前的数组 和<=0了 那就意味着再加就是损害
        //就从这个的下一个开始重新加
        if(nums.length==1){
            return nums[0];
        }
        int sum=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            sum=Math.max(count,sum);
            if(count<=0){
                count=0;
                continue;
            }
        }
        return sum;
    }
}
