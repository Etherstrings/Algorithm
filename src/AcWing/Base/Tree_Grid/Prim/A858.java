package AcWing.Base.Tree_Grid.Prim;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-16 17:46 AcWing.Base.Tree_Grid.Prim - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A858 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  17:46 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  17 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A858 {
    //858. Prim算法求最小生成树
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的无向图，图中可能存在重边和自环，边权可能为负数。
    //
    //求最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
    //
    //给定一张边带权的无向图 G=(V,E)
    //，其中 V
    // 表示图中点的集合，E
    // 表示图中边的集合，n=|V|
    //，m=|E|
    //。
    //
    //由 V
    // 中的全部 n
    // 个顶点和 E
    // 中 n−1
    // 条边构成的无向连通子图被称为 G
    // 的一棵生成树，其中边的权值之和最小的生成树被称为无向图 G
    // 的最小生成树。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行，每行包含三个整数 u,v,w
    //，表示点 u
    // 和点 v
    // 之间存在一条权值为 w
    // 的边。
    //
    //输出格式
    //共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
    //
    //数据范围
    //1≤n≤500
    //,
    //1≤m≤105
    //,
    //图中涉及边的边权的绝对值均不超过 10000
    //。
    //
    //输入样例：
    //4 5
    //1 2 1
    //1 3 2
    //1 4 3
    //2 3 2
    //3 4 4
    //输出样例：
    //6

    public static int N=520;
    public static int INF= 0x3f3f3f3f;

    //图
    public static int[][] grid=new int[N][N];
    //表示当前这个点到连通块的距离是多少
    public static int[] dist=new int[N];
    //这个点在不在连通块里？
    public static boolean[] state=new boolean[N];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        //无向图建图
        for(int i=0;i<N;i++){
            Arrays.fill(grid[i],INF);
        }
        for(int i=0;i<m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            grid[u][v]=grid[v][u]=Math.min(grid[u][v],w);
        }
        //1.初始化Dist数组
        Arrays.fill(dist,INF);
        //2.Prim算法
        int ans=Prim(n);
        if(ans==INF){
            System.out.println("impossible");
        }else {
            System.out.println(ans);
        }
    }
    public static int Prim(int n){
        int len=0;
        for(int i=0;i<n;i++){
            int t=-1;
            //寻找距离S最近的点是哪一个
            for(int j=1;j<=n;j++){
                if(state[j]==false&&(t==-1||dist[t]>dist[j])){
                    t=j;
                }
            }
            //这里是判断这个点是不是在外边，如果这个点在外边，那就无法联通
            //判断是不是第一次进入的第一个点
            if(i!=0&&dist[t]==INF){
                return INF;
            }
            if(i!=0){
                //这个点当前最短，加到里面去
                len+=dist[t];
            }
            state[t]=true;
            for(int j=1;j<=n;j++){
                //更新距离  更新到集合的距离
                dist[j]=Math.min(dist[j],grid[t][j]);
            }
        }
        return len;
    }
}
