package src.Moni;

/**
 * @author Etherstrings
 * @create 2022-08-09 22:59 Moni - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L48 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/9 - the current system date.  22:59 - the current system time.  2022 - the current year.  08 - the current month.  09 - the current day of the month.  22 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L48 {
    //48. 旋转图像
    //给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    //
    //你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[[7,4,1],[8,5,2],[9,6,3]]
    //示例 2：
    //
    //
    //输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    //输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    public void rotate(int[][] matrix) {
        //先按照对角线翻转
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //再直接沿着垂直竖线反转
        for(int i=0;i<n;i++){
            for(int j=0,k=n-1;j<k;j++,k--){
                int temp=matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
