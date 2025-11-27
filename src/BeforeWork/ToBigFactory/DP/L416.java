package ToBigFactory.DP;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Etherstrings
 * @create 2023-07-08 10:51 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L416 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/8 - the current system date.  10:51 - the current system time.  2023 - the current year.  07 - the current month.  08 - the current day of the month.  10 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
    public static boolean canPartition(int[] nums){
        int sum= Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        Path=new LinkedList<>();
        int N=nums.length;
        Flag=false;
        Bucket=0;
        Backtarcking(sum/2,0,N,nums);
        return Flag;
    }
    public static int Bucket;
    public static LinkedList<Integer> Path;
    public static boolean Flag;
    public static void Backtarcking(int sum,int index,int N,int[] nums){
        if(Bucket>sum){
            return;
        }
        if(Bucket==sum){
            if(Path.size()<N){
                Flag=true;
            }
            return;
        }
        for(int i=index;i<N;i++){
            Backtarcking(sum,i+1,N,nums);

            Bucket+=nums[i];
            Path.add(nums[i]);
            Backtarcking(sum,i+1,N,nums);
            Bucket-=nums[i];
            Path.removeLast();
        }
    }
    //背包问题
    public static boolean canPartition1(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        int N = nums.length;
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int Value=sum/2;
        int[][] dp=new int[N+1][Value+1];

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=Value;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }
            }
        }
        for(int i=0;i<=nums.length;i++){
            if(dp[i][Value]==Value){
                return true;
            }
        }
        return false;
    }
}
