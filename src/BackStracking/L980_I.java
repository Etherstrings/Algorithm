package BackStracking;

/**
 * @author Etherstrings
 * @create 2023-08-13 18:02 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L980_I - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/13 - the current system date.  18:02 - the current system time.  2023 - the current year.  08 - the current month.  13 - the current day of the month.  18 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L980_I {
    public int uniquePathsIII(int[][] grid) {
        int left=0;
        int x=-1;
        int y=-1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) left++;
                else if (grid[i][j] == 1) { // 起点
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid,x,y,left+1);
    }

    public static int dfs(int[][] grid,int x,int y,int left){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0)
            return 0; // 不合法
        if (grid[x][y] == 2) // 到达终点
            return left == 0 ? 1 : 0; // 必须访问所有的无障碍方格
        grid[x][y]=-1;// 标记成访问过，因为题目要求「不能重复通过同一个方格」
        int ans=dfs(grid,x-1,y,left-1)+dfs(grid, x, y - 1, left - 1) +
                dfs(grid, x + 1, y, left - 1) + dfs(grid, x, y + 1, left - 1);
        grid[x][y]=0;
        return ans;
    }
}
