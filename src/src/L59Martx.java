package src;

/**
 * @author Etherstrings
 * @create 2022-01-12 16:03 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L59Martx - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/12 - the current system date.  16:03 - the current system time.  2022 - the current year.  01 - the current month.  12 - the current day of the month.  16 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L59Martx {
    public static void main(String[] args) {
    L59Martx l59Martx=new L59Martx();
        int[][] ints = l59Martx.generateMatrix(6);
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(ints[i][j]+"\t");

            }
            System.out.println();
        }
    }


    /**
     * 59. 螺旋矩阵 II
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     */

    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        //圈数
        int Round = n / 2;
        //遍历用num
        int num = 1;


        //判断是偶数还是奇数
        if (n % 2 != 0) {

            //奇数
            //填入正中间的数
            answer[n / 2][n / 2] = n * n;

        }
        //循环的圈数
        //i为圈数
        for (int i = 0; i < Round; i++) {
            //从左到右
            for (int right = i; right < n - i - 1; right++) {
                answer[i][right] = num;
                num++;
            }
            //从右到下
            for (int donw = i; donw < n - i - 1; donw++) {
                answer[donw][n - i - 1] = num;
                num++;
            }
            //从下到左
            for (int left = n - i - 1; left > i; left--) {
                answer[n - i - 1][left] = num;
                num++;
            }
            //从左到上
            for (int up = n - i - 1; up > i; up--) {
                answer[up][i] = num;
                num++;


            }
        }
        return answer;
    }
}
