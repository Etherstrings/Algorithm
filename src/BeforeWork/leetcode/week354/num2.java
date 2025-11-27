package leetcode.week354;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-07-16 10:36 leetcode.week354 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/16 - the current system date.  10:36 - the current system time.  2023 - the current year.  07 - the current month.  16 - the current day of the month.  10 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4,6,1,2},2));
    }
    //每个执行一次 维护可变范围
    public static int maximumBeauty1(int[] nums, int k) {
        int ans=0;
        int[][] Range=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            for(int index=nums[i]-k;index<=nums[i]+k;index++){
                int len=0;
                for(int j=0;j<nums.length;j++){
                    if(i==j){
                        continue;
                    }
                    int nl=nums[j]-k;
                    int nr=nums[j]+k;
                    if(nl<=index&&index<=nr){
                        len++;
                    }
                }
                ans=Math.max(len+1,ans);
            }
        }
        return ans;
    }

    public static int maximumBeauty(int[] nums, int k){
        Arrays.sort(nums);
        int left=0;
        int res=0;
        int right=0;
        while(right<nums.length){
            while(right<nums.length&&nums[right]-nums[left]<=2*k){
                right++;
            }
            res=Math.max(res,right-left);
            left++;
        }
        return res;
    }
}
