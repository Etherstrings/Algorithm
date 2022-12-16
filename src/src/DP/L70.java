package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-22 15:21 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L70 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/22 - the current system date.  15:21 - the current system time.  2022 - the current year.  07 - the current month.  22 - the current day of the month.  15 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L70 {
    //70. 爬楼梯
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //
    //
    //
    //示例 1：
    //
    //输入：n = 2
    //输出：2
    //解释：有两种方法可以爬到楼顶。
    //1. 1 阶 + 1 阶
    //2. 2 阶
    //示例 2：
    //
    //输入：n = 3
    //输出：3
    //解释：有三种方法可以爬到楼顶。
    //1. 1 阶 + 1 阶 + 1 阶
    //2. 1 阶 + 2 阶
    //3. 2 阶 + 1 阶
    public int climbStairs(int n){
        //1.dp数组
            //dp[i] 第i台阶有几种方法？
        //2.dp推导公式
            //一次可以上1或者2
            //假如上1 那就是dp[i-1]的次数
            //假如上2 那就是dp[i-2]的次数
            //dp[i]=dp[i-1]+dp[i-2]
        //3.推导的时候---是按照顺序还是逆序？
            //n需要什么?
            //n需要前边的n-1与n-2
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]%1000000007;
        }
        return dp[n];
    }
}
