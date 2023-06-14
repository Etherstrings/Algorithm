package AcWing.Base.DP.BackageProblem.b_full;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-06-09 14:53 AcWing.Base.DP.BackageProblem.b_full - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A03 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/9 - the current system date.  14:53 - the current system time.  2023 - the current year.  06 - the current month.  09 - the current day of the month.  14 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class A03 {
    //3. 完全背包问题
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //有 N
    // 种物品和一个容量是 V
    // 的背包，每种物品都有无限件可用。
    //
    //第 i
    // 种物品的体积是 vi
    //，价值是 wi
    //。
    //
    //求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
    //输出最大价值。
    //
    //输入格式
    //第一行两个整数，N，V
    //，用空格隔开，分别表示物品种数和背包容积。
    //
    //接下来有 N
    // 行，每行两个整数 vi,wi
    //，用空格隔开，分别表示第 i
    // 种物品的体积和价值。
    //
    //输出格式
    //输出一个整数，表示最大价值。
    //
    //数据范围
    //0<N,V≤1000
    //
    //0<vi,wi≤1000
    //输入样例
    //4 5
    //1 2
    //2 4
    //3 4
    //4 5
    //输出样例：
    //10
    public static int size=10010;
    public static int[] Size=new int[size];
    public static int[] Value=new int[size];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int V=in.nextInt();
        //这样才能保证能够取到第N号物品，以及可以使用V的容量
        int[][] dp=new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            Size[i]=in.nextInt();
            Value[i]=in.nextInt();
        }
        for(int i = 0; i <= V; i++)//初始化
        {
            dp[0][i] = 0;
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                for(int k=0;k*Size[i]<=j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-Size[i]*k]+Value[i]*k);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
