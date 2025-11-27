package AcWing.Base.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-09 21:20 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A847_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/9 - the current system date.  21:20 - the current system time.  2023 - the current year.  05 - the current month.  09 - the current day of the month.  21 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A847_ACM {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] d = new int[N];                //储存每个节点距离起点的距离
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] st = new boolean[N];
    static int idx,n;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int m = in.nextInt();

        for(int i = 0; i < N; i ++)
        {
            h[i] = -1;
            d[i] = -1;
        }

        for(int i = 0; i < m; i ++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a,b);
        }

        System.out.print(bfs(1));           //求的是1-n的最短距离，从1开始搜就可以了
    }

    public static void add(int a, int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int bfs(int u)
    {
        q.offer(u);
        d[1] = 0;                        //自己距离自己为0，在这里的作用相当于表示走过了

        while(q.size() != 0)
        {
            int t = q.poll();
            for(int i = h[t]; i != -1; i = ne[i])
            {
                int j = e[i];           //j相当于当前节点的子节点,因为当前节点会不满足条件直接跳出循环
                if(d[j] == -1)
                {
                    q.offer(j);
                    d[j] = d[t] + 1;
                }
            }
        }
        return d[n];
    }

}
