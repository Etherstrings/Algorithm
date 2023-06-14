package AcWing.Base.DP.BackageProblem.b_infi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-06-09 16:17 AcWing.Base.DP.BackageProblem.b_infi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A04 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/9 - the current system date.  16:17 - the current system time.  2023 - the current year.  06 - the current month.  09 - the current day of the month.  16 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class A04 {
    //4. 多重背包问题 I
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //有 N
    // 种物品和一个容量是 V
    // 的背包。
    //
    //第 i
    // 种物品最多有 si
    // 件，每件体积是 vi
    //，价值是 wi
    //。
    //
    //求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
    //输出最大价值。
    //
    //输入格式
    //第一行两个整数，N，V
    //，用空格隔开，分别表示物品种数和背包容积。
    //
    //接下来有 N
    // 行，每行三个整数 vi,wi,si
    //，用空格隔开，分别表示第 i
    // 种物品的体积、价值和数量。
    //
    //输出格式
    //输出一个整数，表示最大价值。
    //
    //数据范围
    //0<N,V≤100
    //
    //0<vi,wi,si≤100
    //输入样例
    //4 5
    //1 2 3
    //2 4 1
    //3 4 3
    //4 5 2
    //输出样例：
    //10


    public static int size=10010;
    public static int[] Size=new int[size];
    public static int[] Value=new int[size];

    public static int[] Left=new int[size];
    public static void main(String[] args) {
        //第一层：
        // i-[1,N]
        //第二层：
        //j-[0,V]
        //第三层：
        //k-[0,s[i]]
        //k-[0,V[i]*i<j]

        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int V=in.nextInt();

        int[][] dp=new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            Size[i]=in.nextInt();
            Value[i]=in.nextInt();
            Left[i]=in.nextInt();
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                for(int k=0;k*Size[i]<=j&&k<=Left[i];k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-Size[i]*k]+Value[i]*k);
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
