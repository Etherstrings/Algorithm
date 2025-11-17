package AcWing.Base.Tree_Grid.Floyd;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-16 11:19 AcWing.Base.Tree_Grid.Floyd - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A854 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  11:19 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  11 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A854 {
    //854. Floyd求最短路
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的有向图，图中可能存在重边和自环，边权可能为负数。
    //
    //再给定 k
    // 个询问，每个询问包含两个整数 x
    // 和 y
    //，表示查询从点 x
    // 到点 y
    // 的最短距离，如果路径不存在，则输出 impossible。
    //
    //数据保证图中不存在负权回路。
    //
    //输入格式
    //第一行包含三个整数 n,m,k
    //。
    //
    //接下来 m
    // 行，每行包含三个整数 x,y,z
    //，表示存在一条从点 x
    // 到点 y
    // 的有向边，边长为 z
    //。
    //
    //接下来 k
    // 行，每行包含两个整数 x,y
    //，表示询问点 x
    // 到点 y
    // 的最短距离。
    //
    //输出格式
    //共 k
    // 行，每行输出一个整数，表示询问的结果，若询问两点间不存在路径，则输出 impossible。
    //
    //数据范围
    //1≤n≤200
    //,
    //1≤k≤n2
    //
    //1≤m≤20000
    //,
    //图中涉及边长绝对值均不超过 10000
    //。
    //
    //输入样例：
    //3 3 2
    //1 2 1
    //2 3 2
    //1 3 1
    //2 1
    //1 3
    //输出样例：
    //impossible
    //1

    //这里实际上的思路已经是DP了
    //200个点 20000个边
    public static int N=205;
    //存为邻接矩阵
    public static int[][] dp;
    public static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        dp=new int[N][N];
        //1.初始化矩阵
        init(dp);
        //2.初始更新边权重
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int v=in.nextInt();
            dp[a][b]=Math.min(v,dp[a][b]);
        }
        //3.Floyd算法
        Floyd(dp,n);
        //4.读入查询
        for(int i=0;i<k;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            if(dp[a][b]>INF/2){
                System.out.println("impossible");
            }else {
                System.out.println(dp[a][b]);
            }
        }
    }

    /**
     * 初始化DP矩阵-初始化Floyd距离矩阵
     * dp[i][j]-v 代表了从i到j的当前最短路是多少？
     * @param dp
     */
    public static void init(int[][] dp){
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==j){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=INF;
                }
            }
        }
    }

    /**
     * i-j的路径怎么更新？ 从(i-j)和(i-k-j)之间选择一个最小的值更新
     * 用k点去更新i-j的所有路径
     * @param dp
     */
    public static void Floyd(int[][] dp,int n){
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
    }
}
