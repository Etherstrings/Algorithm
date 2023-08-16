package leetcode.week355;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-07-23 10:58 leetcode.week355 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/23 - the current system date.  10:58 - the current system time.  2023 - the current year.  07 - the current month.  23 - the current day of the month.  10 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(maxArrayValue(new int[]{40,15,35,98,77,79,24,62,53,84,97,16,30,22,49}));
    }
    public static long maxArrayValue(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        t=0;
        ans=new ArrayList<>();
        long[] num=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i]=nums[i];
        }
        dfs(num);
        return t;
    }
    public static long t;
    public static List<Long> ans;
    public static void dfs(long[] nums){
        if(nums.length==1){
            return;
        }
        long temp=0;
        temp+=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1){
                if(nums[i]>=nums[i-1]){
                    temp+=nums[i];
                    ans.add(temp);
                }else {
                    ans.add(temp);
                }
                continue;
            }
            if(nums[i]>=nums[i-1]){
                temp+=nums[i];
            }else {
                ans.add(temp);
                temp=0;
                temp+=nums[i];
            }
        }
        long[] num=new long[ans.size()];
        for(int i=0;i<num.length;i++){
            num[i]=ans.get(i);
            t=Math.max(num[i],t);
        }
        ans=new ArrayList<>();
        dfs(num);
    }
}
