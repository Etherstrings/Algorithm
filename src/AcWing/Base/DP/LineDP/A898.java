package AcWing.Base.DP.linedp;

import java.util.Scanner;

public class A898 {
    //898. 数字三角形
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个如下图所示的数字三角形，从顶部出发，在每一结点可以选择移动至其左下方的结点或移动至其右下方的结点，一直走到底层，要求找出一条路径，使路径上的数字的和最大。
    //
    //        7
    //      3   8
    //    8   1   0
    //  2   7   4   4
    //4   5   2   6   5
    //输入格式
    //第一行包含整数 n
    //，表示数字三角形的层数。
    //
    //接下来 n
    // 行，每行包含若干整数，其中第 i
    // 行表示数字三角形第 i
    // 层包含的整数。
    //
    //输出格式
    //输出一个整数，表示最大的路径数字和。
    //
    //数据范围
    //1≤n≤500
    //,
    //−10000≤三角形中的整数≤10000
    //输入样例：
    //5
    //7
    //3 8
    //8 1 0
    //2 7 4 4
    //4 5 2 6 5
    //输出样例：
    //30

    //怎么存？ int[][] grid存
    //左右这两条边 在进行求值的时候 怎么初始化？

    public static int N=510;
    static int INF = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] gird=new int[600][600];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                gird[i][j]=in.nextInt();
            }
        }
        int[][] dp=new int[600][600];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=i+1;j++){
                dp[i][j]=-INF;
            }
        }

        dp[1][1]=gird[1][1];

        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=Math.max(dp[i-1][j-1]+gird[i][j],dp[i-1][j]+gird[i][j]);
            }
        }
        int ans=-INF;
        for(int i=1;i<=n;i++){
            ans=Math.max(dp[n][i],ans);
        }
        System.out.println(ans);
    }
}
