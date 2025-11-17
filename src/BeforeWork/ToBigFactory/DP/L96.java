package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-08 10:41 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L96 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/8 - the current system date.  10:41 - the current system time.  2023 - the current year.  07 - the current month.  08 - the current day of the month.  10 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L96 {
    public static void main(String[] args) {
        System.out.println(numTrees(1));
    }
    // 1到i为节点组成的二叉搜索树的个数为dp[i]。
    //dp[0] = 1
    //dp[1] = 1
    //dp[2] = 0*1 + 1*0
    //dp[3] = 0*2 + 1*1 + 2*0
    public static int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
