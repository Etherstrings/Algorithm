package leetcode.week350;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-06-18 10:37 leetcode.week350 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/18 - the current system date.  10:37 - the current system time.  2023 - the current year.  06 - the current month.  18 - the current day of the month.  10 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        int[] nums={1,51,59,73,98};
        System.out.println(findValueOfPartition(nums));
    }
    public static int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        //先按个断开 然后取左右两边的最大最小值
        int ans=Integer.MAX_VALUE;
        //这样包含了开头和末尾的单个
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                ans=Math.min(Math.abs(nums[i-1]-nums[i]),ans);
                continue;
            }
            ans=Math.min(Math.abs(nums[i]-nums[i+1]),ans);
        }
        //每次取一个数出来 和最大值比较
        for(int i=0;i<nums.length;i++){
            if(i==0||i==nums.length-1){
                continue;
            }
            int now=nums[i];
            ans=Math.min(Math.min(Math.abs(now-nums[0]),Math.abs(now-nums[nums.length-1])),ans);
        }
        return ans;
    }
}
