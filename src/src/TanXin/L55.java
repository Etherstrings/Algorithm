package src.TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-13 22:19 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L55 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/13 - the current system date.  22:19 - the current system time.  2022 - the current year.  07 - the current month.  13 - the current day of the month.  22 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L55 {
    //55. 跳跃游戏
    //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //判断你是否能够到达最后一个下标。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,3,1,1,4]
    //输出：true
    //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    //示例 2：
    //
    //输入：nums = [3,2,1,0,4]
    //输出：false
    //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        //贪心 取最大的跳跃范围

        //核心在于 每一步跳完之后 更新可跳跃范围
        int large=0;
        for(int i=0;i<= large;i++){
            large=Math.max(i+nums[i],large);
            if(large>= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
