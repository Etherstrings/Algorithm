package DP;

/**
 * @author Etherstrings
 * @create 2022-09-14 0:48 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L673_LongestBigger - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  0:48 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  00 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L673_LongestBigger {
    public int findNumberOfLIS(int[] nums) {
        //dp[]
        //以i结尾的子串 所具有的递增的子串的最大长度
        //count[i]
        //以i结尾的子串 所具有的递增的最大子串的个数
        if(nums.length<=1){
            return nums.length;
        }
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];

        //初始化
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
            count[i]=1;
        }
        int max=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    //当前位置的最大长度如果加上这个是大于目标位置的
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
                //判断是不是最长的
                if(dp[i]>max){
                    max=dp[i];
                }
            }
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==max){
                ans+=count[i];
            }
        }
        return ans;


    }
}
