package Luogu;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-15 11:52 Luogu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  NOIP2002_AC - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/15 - the current system date.  11:52 - the current system time.  2023 - the current year.  05 - the current month.  15 - the current day of the month.  11 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class NOIP2002_AC {

    public static void main(String[] args) {
        int d[][] = {
                {0, 0}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, -1}, {-2, 1}
        };
        int[][] ctr = new int[30][30];
        long[][] dp = new long[30][30];
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int hx = sc.nextInt();
        int hy = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            int tmpx = d[i][0] + hx;
            int tmpy = d[i][1] + hy;
            if (tmpx >= 0 && tmpx <= n && tmpy >= 0 && tmpy <= m)
                ctr[tmpx][tmpy] = 1;
        }
        dp[0][0] = 1 - ctr[0][0];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (ctr[i][j] == 1) {
                    continue;
                }
                if (i != 0) dp[i][j] += dp[i - 1][j];
                if (j != 0) dp[i][j] += dp[i][j - 1];
            }
        }
        System.out.println(dp[n][m]);
    }
}
