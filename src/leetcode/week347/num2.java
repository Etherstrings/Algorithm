package leetcode.week347;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2023-05-28 10:41 leetcode.week347 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/28 - the current system date.  10:41 - the current system time.  2023 - the current year.  05 - the current month.  28 - the current day of the month.  10 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,2,3},{3,1,5},{3,2,1}};
        int[][] ans=differenceOfDistinctValues(grid);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int level=grid.length;
        int col=grid[0].length;
        int[][] ans=new int[level][col];
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                ans[i][j]=getsize(grid,level,col,i,j);
            }
        }
        return ans;
    }

    public static int getsize(int[][] board, int row, int col,int x,int y) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        for(int i=x+1,j=y+1;i<row&&j<col;i++,j++){
            set1.add(board[i][j]);
        }
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){
            set2.add(board[i][j]);
        }
        int left=set1.size()==0?0:set1.size();
        int right=set2.size()==0?0:set2.size();
        return Math.abs(left-right);
    }
}
