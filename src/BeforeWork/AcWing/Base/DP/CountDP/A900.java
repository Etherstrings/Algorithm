package AcWing.Base.DP.CountDP;

import java.util.Scanner;

public class A900 {
    //完全背包问题
    //有n个物品 每个物品的体积从1-n 每个物品可以取无限次
    //问能够恰好拿满的有多少种方式？


    //900. 整数划分
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //一个正整数 n
    // 可以表示成若干个正整数之和，形如：n=n1+n2+…+nk
    //，其中 n1≥n2≥…≥nk,k≥1
    //。
    //
    //我们将这样的一种表示称为正整数 n
    // 的一种划分。
    //
    //现在给定一个正整数 n
    //，请你求出 n
    // 共有多少种不同的划分方法。
    //
    //输入格式
    //共一行，包含一个整数 n
    //。
    //
    //输出格式
    //共一行，包含一个整数，表示总划分数量。
    //
    //由于答案可能很大，输出结果请对 109+7
    // 取模。
    //
    //数据范围
    //1≤n≤1000
    //输入样例:
    //5
    //输出样例：
    //7
    public static final int N = 1010;
    public static final int M = (int) (1e9 + 7);
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] dp=new int[N][N];
        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k*i<=j;k++){
                    dp[i][j]+=dp[i-1][j-k*i];
                    dp[i][j]%=M;
                }
            }
        }
        System.out.println(dp[n][n]);
    }

}
