package TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-14 19:37 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L45 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/14 - the current system date.  19:37 - the current system time.  2022 - the current year.  07 - the current month.  14 - the current day of the month.  19 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L45 {
    //45. 跳跃游戏 II
    //给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    //
    //假设你总是可以到达数组的最后一个位置。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [2,3,1,1,4]
    //输出: 2
    //解释: 跳到最后一个位置的最小跳跃数是 2。
    //     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    //示例 2:
    //
    //输入: nums = [2,3,0,1,4]
    //输出: 2

    public int jump(int[] nums) {
        //总能跳到最后一个位置
        //怎么用最短的跳到呢？
        //1.谨慎下一个位置
        //2.如果可覆盖>=nums.length-1 那就是找到了
        if(nums.length==0||nums.length==1||nums==null){
            return 0;
        }
        int count=0;
        int now=0;
        int max=0;
        for(int i=0;i< nums.length;i++){
            //更新现在
            max=Math.max(i+nums[i],max);

            //更新后的最大的值 已经到了
            if(max>=nums.length-1){
                //就是现在可以跳的位置 已经实际上大于最后的位置了
                //但是还没跳
                count++;
                break;
            }

            //现在已经走到了当前只能走到的位置了
            //不得已必须继续走下一步
            if(i==now){
                now=max;
                //走一步
                count++;
            }
        }
        return count;
    }
}
