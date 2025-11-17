package AcWing.Base.DP.BackageProblem.b_01;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-29 18:02 AcWing.Base.DP.BackageProblem.b_01 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A02 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/29 - the current system date.  18:02 - the current system time.  2023 - the current year.  05 - the current month.  29 - the current day of the month.  18 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A02 {
    //1.一定要想明白DP这个二维数组的含义
    //dp[i][j]表示--当前考虑第i个物品，而j则是当前背包所能使用的容量
    //2.初始化
    //当前的背包容量只有0的时候 那一个都选不了 就是dp[i][0]都初始化为0
    //当前的物品选择0号，也就是一个都没选的时候，无论容量多大 价值都是0 就是dp[0][j]都初始化为0
    //3.更新方程
    //首先考虑 当前背包的最大容量 能不能支持当前选的这个物品的size
    //               j          size[i]
    //如果不能支持 --不选---那就只能复用这么大容量的上一个物品的选择情况
    //dp[i][j]=dp[i-1][j];
    //如果支持--那就可以考虑选
    //那选择的就是上一个物品的情况中，减去满足当前i号物品大小的容量时的最大价值，加上当前价值
    //dp[i][j]=dp[i-1][j-size[i]]+value[i]
    //那么什么时候，拿下的价值最高？
    //考虑完所有物品/考虑到最大容量时，拿下的价值最高
    //4.怎么更新？ 按照物品考虑 挨个考虑物品 考虑可用Size
    //外i 里j


    //2. 01背包问题
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //有 N
    // 件物品和一个容量是 V
    // 的背包。每件物品只能使用一次。
    //
    //第 i
    // 件物品的体积是 vi
    //，价值是 wi
    //。
    //
    //求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
    //输出最大价值。
    //
    //输入格式
    //第一行两个整数，N，V
    //，用空格隔开，分别表示物品数量和背包容积。
    //
    //接下来有 N
    // 行，每行两个整数 vi,wi
    //，用空格隔开，分别表示第 i
    // 件物品的体积和价值。
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
    //8

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
        //初始化
        //递归顺序
        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                //考虑不选的情况
                dp[i][j]=dp[i-1][j];
                //当前的容量满不满足此物品的size？
                if(j>=Size[i]){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-Size[i]]+Value[i]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
