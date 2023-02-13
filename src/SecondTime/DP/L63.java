package SecondTime.DP;

/**
 * @author Etherstrings
 * @create 2022-08-29 17:07 SecondTime.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L63 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  17:07 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  17 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int level=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[level][col];
        dp[0][0]=1;
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
        for(int i=0;i<col;i++){
            dp[0][i]=1;
            if(obstacleGrid[0][i]==1){
                Cflag=i;
                dp[0][i]=0;
                break;
            }
        }
        if(Cflag!=-1){
            for(int i=Cflag;i<col;i++){
                dp[0][i]=0;
            }
        }

        for(int i=1;i<level;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else {
                    dp[i][j]=0;
                }

            }
        }
        return dp[level-1][col-1];
    }
}
