package AcWing.Base.Tree_Grid.SPFA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-13 11:21 AcWing.Base.Tree_Grid.SPFA - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A852 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/13 - the current system date.  11:21 - the current system time.  2023 - the current year.  05 - the current month.  13 - the current day of the month.  11 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A852_ACM {
    //852. spfa判断负环
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
    //
    //请你判断图中是否存在负权回路。
    //
    //输入格式
    //第一行包含整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行每行包含三个整数 x,y,z
    //，表示存在一条从点 x
    // 到点 y
    // 的有向边，边长为 z
    //。
    //
    //输出格式
    //如果图中存在负权回路，则输出 Yes，否则输出 No。
    //
    //数据范围
    //1≤n≤2000
    //,
    //1≤m≤10000
    //,
    //图中涉及边长绝对值均不超过 10000
    //。
    //
    //输入样例：
    //3 3
    //1 2 -1
    //2 3 4
    //3 1 -4
    //输出样例：
    //Yes

    //spfa算法怎么判断其中存在负环？
    //1.维护一个路径长度数组cnt[]
    //2.每次在成功更新dist[x]的时候更新cnt[x]
    //3.cnt[x]=cnt[j]+1
    //4.当cnt[x]>=n的时候，就意味着出现了负环
    public static int N=100010,M=100010;

    //路径长度数组
    public static int[] cnt=new int[N];
    public static int[] dist=new int[N];

    //判断是否更新数组
    public static boolean[] used=new boolean[N];

    //邻接表
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx = 1;
    //模拟数组版的初始构建
    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c;ne[idx] = h[a]; h[a] = idx++;
    }
    public static void main(String[] args) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        //初始化邻接矩阵
        Arrays.fill(h,-1);
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            add(a,b,c);
        }
        if(spfa(n)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean spfa(int n) {
        // 应为负环不一定是从1点开始的路径上，所以要加入所有的点
        // 因为我们求的不是有没有负环，所以 dist[] 不需要初始化为最大值，可以画一个图模拟
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);

        while (!q.isEmpty()) {
            int t = q.poll();
            used[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;

                    if (!used[j]) {
                        used[j] = true;
                        q.offer(j);
                    }
                }
            }
        }

        return false;
    }

}
