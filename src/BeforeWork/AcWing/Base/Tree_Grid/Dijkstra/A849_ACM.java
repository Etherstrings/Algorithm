package AcWing.Base.Tree_Grid.Dijkstra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-10 15:07 AcWing.Base.Tree_Grid.Dijkstra - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A849 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/10 - the current system date.  15:07 - the current system time.  2023 - the current year.  05 - the current month.  10 - the current day of the month.  15 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A849_ACM{
    //849. Dijkstra求最短路 I
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的有向图，图中可能存在重边和自环，所有边权均为正值。
    //
    //请你求出 1
    // 号点到 n
    // 号点的最短距离，如果无法从 1
    // 号点走到 n
    // 号点，则输出 −1
    //。
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
    //输出一个整数，表示 1
    // 号点到 n
    // 号点的最短距离。
    //
    //如果路径不存在，则输出 −1
    //。
    //
    //数据范围
    //1≤n≤500
    //,
    //1≤m≤105
    //,
    //图中涉及边长均不超过10000。
    //
    //输入样例：
    //3 3
    //1 2 2
    //2 3 1
    //1 3 4
    //输出样例：
    //3
    public static int N=510;


    //为稠密阵所以用邻接矩阵存储
    public static int[][] g=new int[N][N];

    //用于记录每一个点距离第一个点的距离
    public static int[] dist;

    //用于记录该点的最短距离是否已经确定
    public static boolean[] st;

    public static int n,m;

    public static void main(String[] args) {
        //初始化图 每个点设置为无限大
        for(int[] t:g){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        dist=new int[n+1];
        st=new boolean[n+1];
        for(int i=0;i<m;i++){
            int f=in.nextInt();
            int t=in.nextInt();
            int v=in.nextInt();
            //重边 保留最小的一条边
            g[f][t]=Math.min(g[f][t],v);
        }
        System.out.println(Dijkstra());

    }

    public static int Dijkstra(){
        //初始化距离
        Arrays.fill(dist,Integer.MAX_VALUE);

        //从哪个点开始找？
        dist[1]=0;

        for(int i=0;i<n;i++){
            //t存储当前访问的点
            int t=-1;
            for(int j=1;j<=n;j++){

                if(st[j]==false&&(t==-1||dist[t]>dist[j])){
                    t=j;
                }


            }
            st[t]=true;
            for(int j=1;j<=n;j++){
                if(g[t][j]==Integer.MAX_VALUE){
                    continue;
                }
                dist[j]=Math.min(dist[j],dist[t]+g[t][j]);
            }
        }
        if(dist[n]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[n];
    }

}
