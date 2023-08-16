package BackStracking;

/**
 * @author Etherstrings
 * @create 2023-08-09 18:52 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L980 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/9 - the current system date.  18:52 - the current system time.  2023 - the current year.  08 - the current month.  09 - the current day of the month.  18 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L980 {
    //什么样才算是找到了？
    //所有格子走了一遍
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int left=0;
        int x = 0,y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    left++;
                }
                if(grid[i][j]==1){
                    x=i;
                    y=j;
                }
            }
        }
        used=new boolean[n][m];
        ans=0;
        used[x][y]=true;
        left++;
        dfs(grid,x,y,left);
        return ans;
    }
    public static boolean[][] used;
    public static int ans;
    public void dfs(int[][] grid,int x,int y,int left){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if(grid[x][y]==2&&left==0){
            ans++;
            return;
        }
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        for(int i=0;i<4;i++) {
            int nowx = x + dir[i][0];
            int nowy = y + dir[i][1];
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                return;
            }
            if(used[nowx][nowy]){
                continue;
            }else {
                if(grid[nowx][nowy]==-1){
                    continue;
                }
                if(grid[nowx][nowy]==0){
                    used[nowx][nowy]=true;
                    left--;
                    dfs(grid,nowx,nowy,left);
                    used[nowx][nowy]=false;
                    left++;
                }
            }
        }
    }
}
