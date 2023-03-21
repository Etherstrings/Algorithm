package DFS;

/**
 * @author Etherstrings
 * @create 2023-03-08 16:08 BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S47 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/8 - the current system date.  16:08 - the current system time.  2023 - the current year.  03 - the current month.  08 - the current day of the month.  16 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class S47 {
    public int maxValue(int[][] grid) {
        dfs(grid,0,0,0);
        return a;
    }
    int a=Integer.MIN_VALUE;
    public void dfs(int[][] grid,int level,int col,int temp){
        if(level==grid.length||col==grid[0].length){
            return;
        }
        if(level==grid.length-1&&col==grid[0].length-1){
            //到达位置
            temp+=grid[level][col];
            a=Math.max(temp,a);
            return;
        }
            temp+=grid[level][col];
            dfs(grid,level+1,col,temp);
            dfs(grid,level,col+1,temp);

    }
}
