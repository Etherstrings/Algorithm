package ShuangZhiZhen;

/**
 * @author Etherstrings
 * @create 2022-09-12 13:07 ShuangZhiZhen - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  GetWater - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/12 - the current system date.  13:07 - the current system time.  2022 - the current year.  09 - the current month.  12 - the current day of the month.  13 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class GetWater {
    //接雨水
    //双指针

    public int trap(int[] height) {
        //1.按照每一列来算
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            //每一列记录左侧最大值
            int left=-1;
            //右边最大值
            int right=1;
            int now=height[i];
            for(int j=0;j<i;j++){
                left=Math.max(left,height[j]);
            }
            for(int j=i+1;j<height.length;j++){
                right=Math.max(right,height[j]);
            }
            //当前列存的值
            int h = Math.min(left, right) - height[i];
            if(h>0){
                sum+=h;
            }
        }
        return sum;
    }

    public int trap1(int[] height){
        //动态规划
        //dp[][]
        //dp[i][j]  i 表示位置 j-0代表左侧的最大值 1代表右侧的最大值
        int[][] dp=new int[height.length][2];
        //赋值初始值
        //i==0
        dp[0][0]=0;
        dp[0][1]=-1;
        for(int i=1;i<height.length;i++){
            dp[0][1]=Math.max(height[i],dp[0][1]);
        }
        //i==height.lenght
        dp[height.length-1][0]=-1;
        dp[height.length-1][1]=0;
        for(int i=height.length-1;i>=0;i--){
            dp[height.length-1][0]=Math.max(height[i],dp[height.length-1][0]);
        }
        //递推公式
        //左边最大值的递推公式
        for(int i=1;i<height.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],height[i-1]);
        }
        //右边最大值的递推公式
        for(int i=height.length-2;i>=0;i--){
            dp[i][1]=Math.max(dp[i+1][1],height[i+1]);
        }
        //sum
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int count = Math.min(dp[i][0], dp[i][1]) - height[i];
            if(count>0){
                sum+=count;
            }
        }
        return sum;
    }
}
