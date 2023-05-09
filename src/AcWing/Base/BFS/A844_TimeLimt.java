package AcWing.Base.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-05-05 15:15 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A844_TimeLimt - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/5 - the current system date.  15:15 - the current system time.  2023 - the current year.  05 - the current month.  05 - the current day of the month.  15 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A844_TimeLimt {
    static class Point {
        int x, y, step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    static int[][] g = new int[110][110];
    static boolean[][] flag = new boolean[110][110];
    static Queue<Point> queue = new ArrayDeque<>();
    static int n, m;

    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static void bfs() {
        int x = 1, y = 1;
        //x,y入队
        queue.add(new Point(x, y, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == n && p.y == m) {
                System.out.println(p.step);
                return;
            }
            for (int i = 0; i < 4; i++) {
                x = p.x + mx[i];
                y = p.y + my[i];
                if (x > 0 && x <= n && y > 0 && y <= m && !flag[x][y] && g[x][y] == 0) {
                    flag[x][y] = true;
                    queue.add(new Point(x, y, p.step + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        String[] strs = in.readLine().split(" ");

        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        for (int i = 1; i <= n; i++) {
            strs = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) g[i][j] = Integer.parseInt(strs[j - 1]);
        }

        bfs();

        in.close();
        isr.close();
    }

}
