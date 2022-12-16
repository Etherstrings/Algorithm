package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-25 21:20 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L96 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/25 - the current system date.  21:20 - the current system time.  2022 - the current year.  07 - the current month.  25 - the current day of the month.  21 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L96 {
    //96. 不同的二叉搜索树
    //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：n = 3
    //输出：5
    //示例 2：
    //
    //输入：n = 1
    //输出：1
    public int numTrees(int n) {
        //dp数组含义----i节点的所有构成搜索树的个数
        int[] dp=new int[n+1];

        //递推公式
        //dp[i] += dp[j - 1] * dp[i - j];

        //初始化
        //dp[0]=1

        //遍历顺序 从上往下
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i]+=dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
