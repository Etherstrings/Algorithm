package DP;

/**
 * @author Etherstrings
 * @create 2023-02-17 12:26 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1139 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/17 - the current system date.  12:26 - the current system time.  2023 - the current year.  02 - the current month.  17 - the current day of the month.  12 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1139 {
    //从左往右当前有多少个连续的1 dp[i][j][0]
    //从上往下当前有多少个连续的1 dp[i][j][1]
    //不停的更新边长长度 如果为1 那就是失败
    public int largest1BorderedSquare(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length][2];
        int level=grid.length;
        int col=grid[0].length;

        //1.先横向
        //1.1 初始化左边一列
        for(int i=0;i<level;i++){
            if(grid[i][0]==0){
                dp[i][0][0]=0;
            }else {
                dp[i][0][0]=1;
            }
        }

        //1.2 横向dp
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                //更新横向
                if(j==0){
                    continue;
                }
                if(grid[i][j]==0){
                    dp[i][j][0]=0;
                }else {
                    dp[i][j][0]=dp[i][j-1][0]+1;
                }
            }
        }

        //2.再从上往下
        //2.1 初始化第一行
        for(int i=0;i<col;i++){
            if(grid[0][i]==0){
                dp[0][i][1]=0;
            }else {
                dp[0][i][1]=1;
            }
        }

        for(int j=0;j<col;j++){
            for(int i=0;i<level;i++){
                if(i==0){
                    continue;
                }
                if(grid[i][j]==0){
                    dp[i][j][1]=0;
                }else {
                    dp[i][j][1]=dp[i-1][j][1]+1;
                }
            }
        }
        int maxSide = 0;//边长的最大长度
        //遍历 找出最小的边长
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if(curSide<=maxSide){
                    continue;
                }
                //此时计算正方形的上边和左边长度
                //判断正方形的左边和上边的长度是否大于curSide，如果不大于，我们就缩小正方形
                //的长度curSide，然后继续判断
                for(;curSide>maxSide;curSide--){
                    //比如当前到了右下角 4 4
                    //当前的长度为3
                    //上边的长度为 dp[i - curSide + 1][j][0]
                    //左边的长度为 dp[i][j - curSide + 1][1]
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        //更短的就没必要考虑了，这里直接中断
                        break;
                    }
                }
            }
        }
        return maxSide*maxSide;
    }
}
