package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-25 15:38
 */
public class L62 {
    //dp数组---dp[i][j] 当前具有多少种方式

    //递推----机器人只能向下或者向右移动一步---也就是这个的所有可能性为上一步两种可能性相加
    //dp[i][j]=dp[i-1][j]+dp[i][j-1] ---如果当时选择向右移动 如果选择向下移动

    //初始条件
    //dp[0][0]=0----从这里到这一行或者这一列
    //比如第一行 到当前的dp[0][j]==1 dp[i][0]==1

    //递推的方向
        //一行一行 从左往右
        //当前状态从上一步状态提取  所以要从先可以获取之前状态的顺序遍历
    public static int uniquePaths(int m, int n){
        //动态数组
        int[][] dp=new int[m][n];
        //初始化第一列
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        //初始化第一行
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        //动态递归
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }
}
