package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-25 16:01
 */
public class L63 {
    //63. 不同路径 II
    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
    //
    //现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    //
    //网格中的障碍物和空位置分别用 1 和 0 来表示。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    //输出：2
    //解释：3x3 网格的正中间有一个障碍物。
    //从左上角到右下角一共有 2 条不同的路径：
    //1. 向右 -> 向右 -> 向下 -> 向下
    //2. 向下 -> 向下 -> 向右 -> 向右
    //示例 2：
    //
    //
    //输入：obstacleGrid = [[0,1],[0,0]]
    //输出：1
    //
    //
    //提示：
    //
    //m == obstacleGrid.length
    //n == obstacleGrid[i].length
    //1 <= m, n <= 100
    //obstacleGrid[i][j] 为 0 或 1
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //核心----在DP数组中 障碍物所在的格----永远都无法抵达---dp[][]障碍物---0
        //1.初始化DP数组
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        int level=obstacleGrid.length;
        int row=obstacleGrid[0].length;
        //2.初始化dp条件
            //初始化行列
        int Lflag=-1;
        for(int i=0;i<level;i++){
            dp[i][0]=1;
            //初始化第一列 一旦遇到一个有障碍物的---剩下的就无法到达---对 因为只能向下和向右
            if(obstacleGrid[i][0]==1){
                Lflag=i;
                dp[i][0]=0;
                break;
            }
        }
        if(Lflag!=-1){
            for(int i=Lflag;i<level;i++){
                dp[i][0]=0;
            }
        }


        int Cflag=-1;
        for(int i=0;i<row;i++){
            dp[0][i]=1;
            if(obstacleGrid[0][i]==1){
                Cflag=i;
                dp[0][i]=0;
                break;
            }
        }
        if(Cflag!=-1){
            for(int i=Cflag;i<row;i++){
                dp[0][i]=0;
            }
        }
        //3.递推公式
            //dp[i][j]=dp[i-1][j]+dp[j-1];
        //4.遍历的顺序与特殊条件
            //规定从上往下 从左往右 一次一个
        for(int i=1;i<level;i++){
            for(int j=1;j<row;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return dp[level-1][row-1];
    }
}
