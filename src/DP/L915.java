package DP;

/**
 * @author Etherstrings
 * @create 2023-02-28 11:16 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L915 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/28 - the current system date.  11:16 - the current system time.  2023 - the current year.  02 - the current month.  28 - the current day of the month.  11 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L915 {
    //915. 分割数组
    //给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
    //
    //left 中的每个元素都小于或等于 right 中的每个元素。
    //left 和 right 都是非空的。
    //left 的长度要尽可能小。
    //在完成这样的分组后返回 left 的 长度 。
    //
    //用例可以保证存在这样的划分方法。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [5,0,3,8,6]
    //输出：3
    //解释：left = [5,0,3]，right = [8,6]
    //示例 2：
    //
    //输入：nums = [1,1,1,0,6,12]
    //输出：4
    //解释：left = [1,1,1,0]，right = [6,12]
    public int partitionDisjoint(int[] nums) {
        int ans=0;
        //左边的最大值
        //右边的最小值
        //左big<右right
        //left尽可能的小
        int bigleft=-1;
        int minright=Integer.MAX_VALUE;
        int[] dp=new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        //当前位置，包括当前位置 右边的最小值是多少
        for(int i=nums.length-1;i>=0;i--){
            //右边的最小值
            if(i==nums.length-1){
                continue;
            }
            dp[i]=Math.min(dp[i+1],nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            int now=nums[i];
            bigleft=Math.max(bigleft,nums[i]);
            if(bigleft<=dp[i+1]){
                ans=i-0+1;
                break;
            }
        }
        return ans;
    }
}
