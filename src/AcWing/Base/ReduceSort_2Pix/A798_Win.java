package AcWing.Base.ReduceSort_2Pix;

import java.io.*;

/**
 * @author Etherstrings
 * @create 2023-03-24 0:15 AcWing.Base.ReduceSort_2Pix - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A798_Win - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/24 - the current system date.  0:15 - the current system time.  2023 - the current year.  03 - the current month.  24 - the current day of the month.  00 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A798_Win {
    public static void main(String[] args) throws IOException {
        //普遍Scanner会超时，所以使用BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str1 = reader.readLine().split(" ");

        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int q = Integer.parseInt(str1[2]);
        int N = 1010;
        int[][] a = new int[N][N];
        int[][] b = new int[N][N];

        // 读入原数组
        for (int i = 1; i <= n; i++) {
            String[] str2 = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(str2[j-1]);
                // 初始化差分数组
                insert(b, i, j, i, j, a[i][j]);
            }
        }


        while (q-- > 0) {
            String[] str3 = reader.readLine().split(" ");
            int x1 = Integer.parseInt(str3[0]);
            int y1 = Integer.parseInt(str3[1]);
            int x2 = Integer.parseInt(str3[2]);
            int y2 = Integer.parseInt(str3[3]);
            int k  =  Integer.parseInt(str3[4]);
            insert(b, x1, y1, x2, y2, k);
        }

        // 求b数组的前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i][j - 1] + b[i - 1][j] - b[i - 1][j - 1];
                //输出
                writer.write(b[i][j] + " ");
            }
            writer.write("\n");
        }
        //所有write下的内容，会先存在writers中，当启用flush以后，会输出存在其中的内容。如果没有调用flush，则不会将writer中的内容进行输出。
        writer.flush();
        reader.close();
        writer.close();
    }

    // 插入操作函数
    private static void insert(int[][] b, int x1, int y1, int x2, int y2, int k) {
        b[x1][y1] += k;
        b[x2 + 1][y1] -= k;
        b[x1][y2 + 1] -= k;
        b[x2 + 1][y2 + 1] += k;
    }

}
