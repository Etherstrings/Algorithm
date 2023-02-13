package Moni;

/**
 * @author Etherstrings
 * @create 2022-08-15 23:08 Moni - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L240 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/15 - the current system date.  23:08 - the current system time.  2022 - the current year.  08 - the current month.  15 - the current day of the month.  23 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L240 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int level=matrix.length;
        int col=matrix[0].length;
        if(matrix[0][0]>target){
            return false;
        }
        if(target>matrix[level-1][col-1]){
            return false;
        }
        boolean Flag=false;
        int i=0;
        int j=0;
        for(;j<col;j++){
            if(matrix[i][j]>target){
                j=j-1;
                break;
            }else if(matrix[i][j]==target){
                return true;
            }
        }
        if(j==col){
            j=j-1;
        }
        for(;i<level;i++){
            if(matrix[i][j]==target){
                Flag=true;
                break;
            }
        }
        return Flag;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

}
