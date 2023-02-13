package src.leetcode.week1time.week84;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-08-07 11:47 leetcode.week1time.week84 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6142 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/7 - the current system date.  11:47 - the current system time.  2022 - the current year.  08 - the current month.  07 - the current day of the month.  11 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6142 {
    //6142. 统计坏数对的数目
    //给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
    //
    //请你返回 nums 中 坏数对 的总数目
    public long countBadPairs(int[] nums) {

        //动态规划呢？
        //当前位置的最大坏数对
        long[] dp=new long[nums.length];

        dp[0]=0;

        //递推公式
        //那就是当前这个是不是坏数队

        //dp[i]+=0-i-1 所以的可能性
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1];
            for(int j=0;j<i;j++){
                if(isbd(nums,j,i)){
                    dp[i]+=1;
                }
            }
        }
        return dp[nums.length-1];

    }

    boolean isbd(int[] nums,int j,int i){
        //如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
        if(i-j!=nums[i]-nums[j]){
            return true;
        }
        return false;
    }

    public long countBadPairs1(int[] nums){
        long n=nums.length;

        long cnt=(n*(n-1)/2);

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int d=nums[i]-i;
            int t=map.getOrDefault(d,0);

            cnt-=t;
            map.put(d,t+1);
        }
        return cnt;
    }
}
