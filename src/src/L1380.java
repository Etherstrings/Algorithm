package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-16 0:06 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1380 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  0:06 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  00 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1380 {
    //1380. 矩阵中的幸运数
    //给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
    //
    //幸运数是指矩阵中满足同时下列两个条件的元素：
    //
    //在同一行的所有元素中最小
    //在同一列的所有元素中最大
    public List<Integer> luckyNumbers (int[][] matrix) {
        //思路
        //m X n
        //int[0]- int[m]-----先从每行中选出最小值 j

        //int[0][j]-int[n][j]------取出这几个数 判断j所在位置数值是否为最大
        List<Integer> answer=new ArrayList<>();

        //行数
        int m=matrix.length;
        //列数
        int[] nums=matrix[0];
        int n=nums.length;

        for(int i=0;i<m;i++){
            //保存每一行
            int[] Hang=new int[n];
            for(int j=0;j<n;j++){
                //给每一行取出后赋值
                Hang[j]=matrix[i][j];
            }
            Arrays.sort(Hang);
            for(int j=0;j<n;j++){
                if(Hang[0]==matrix[i][j]){
                    //保存当前行数最小值所在位置的列
                    int[] Lie=new int[m];
                    for(int k=0;k<m;k++){
                        Lie[k]=matrix[k][j];
                    }
                    Arrays.sort(Lie);
                    if(Lie[m-1]==matrix[i][j]){
                        answer.add(matrix[i][j]);
                    }
                }
            }

        }
        return answer;


    }
}
