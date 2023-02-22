package DP;

/**
 * @author Etherstrings
 * @create 2023-02-22 23:17 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1326 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/22 - the current system date.  23:17 - the current system time.  2023 - the current year.  02 - the current month.  22 - the current day of the month.  23 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1326 {
    public int minTaps(int n, int[] ranges) {
        //动态规划
        //从此点出发往右走 能够最远到达哪个点？
        int[] dp = new int[n + 1];

        //当前要不要更新0的数值？
        for(int i=0;i<=n;i++){
            //当前这个点的范围
            int r=ranges[i];

            if(i>r){
                //当前为3
                //但是范围为2
                //没法从0直接到3
                dp[i-r]=i+r;
            }else {
                dp[0]=Math.max(dp[0],i+r);
            }
        }
        int ans=0;
        //当前可以到达的最大右边
        int nowright=0;
        //下一个可以达到的最大右边
        int nextright=0;
        for(int i=0;i<n;i++){
            nextright=Math.max(nextright,dp[i]);

            if(i==nowright){
                if(i==nextright){
                    return -1;
                }
                nowright=nextright;
                ans++;
            }
        }
        return ans;

    }
}
