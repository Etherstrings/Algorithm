package AcWing.Base.DP.BackageProblem.b_div;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-06-09 17:29 AcWing.Base.DP.BackageProblem.b_div - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A09 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/9 - the current system date.  17:29 - the current system time.  2023 - the current year.  06 - the current month.  09 - the current day of the month.  17 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class A09 {
    /**
     *
     核心数组
     int f[N][N];  //只从前i组物品中选，当前体积小于等于j的最大值
     int v[N][N],w[N][N],s[N];   //v为体积，w为价值，s代表第i组物品的个数

     递归过程
     for(int i=1;i<=n;i++){
     for(int j=0;j<=m;j++){
     f[i][j]=f[i-1][j];  //不选
     for(int k=0;k<s[i];k++){
     if(j>=v[i][k])     f[i][j]=max(f[i][j],f[i-1][j-v[i][k]]+w[i][k]);
     }
     }
     }

     按照01背包的方式进行优化---更改遍历顺序
     const int N=110;
     int f[N];
     int v[N][N],w[N][N],s[N];
     int n,m,k;

     for(int i=0;i<n;i++){
     for(int j=m;j>=0;j--){
     for(int k=0;k<s[i];k++){    //for(int k=s[i];k>=1;k--)也可以
     if(j>=v[i][k])     f[j]=max(f[j],f[j-v[i][k]]+w[i][k]);
     }
     }
     }
     */

    //9. 分组背包问题
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //有 N
    // 组物品和一个容量是 V
    // 的背包。
    //
    //每组物品有若干个，同一组内的物品最多只能选一个。
    //每件物品的体积是 vij
    //，价值是 wij
    //，其中 i
    // 是组号，j
    // 是组内编号。
    //
    //求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。
    //
    //输出最大价值。
    //
    //输入格式
    //第一行有两个整数 N，V
    //，用空格隔开，分别表示物品组数和背包容量。
    //
    //接下来有 N
    // 组数据：
    //
    //每组数据第一行有一个整数 Si
    //，表示第 i
    // 个物品组的物品数量；
    //每组数据接下来有 Si
    // 行，每行有两个整数 vij,wij
    //，用空格隔开，分别表示第 i
    // 个物品组的第 j
    // 个物品的体积和价值；
    //输出格式
    //输出一个整数，表示最大价值。
    //
    //数据范围
    //0<N,V≤100
    //
    //0<Si≤100
    //
    //0<vij,wij≤100
    //输入样例
    //3 5
    //2
    //1 2
    //2 4
    //1
    //3 4
    //1
    //4 5
    //输出样例：
    //8
    public static int size=110;
    public static int[][] dp=new int[size][size];
    public static int[][] Size=new int[size][size];
    public static int[][] Value=new int[size][size];
    public static int[] S=new int[size];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int V=in.nextInt();
        for(int i=1;i<=N;i++){
            //第几组
            int nowsize=in.nextInt();
            S[i]=nowsize;
            for(int j=0;j<nowsize;j++){
                int ss=in.nextInt();
                int v=in.nextInt();
                Size[i][j]=ss;
                Value[i][j]=v;
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                //不选
                dp[i][j]=dp[i-1][j];
                for(int k=0;k<S[i];k++){
                    //遍历第K组

                    //只有 当前的背包容量 才可以考虑更新这一组的这个物品
                    if(j>=Size[i][k]){
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-Size[i][k]]+Value[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
