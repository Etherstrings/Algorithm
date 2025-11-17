package AcWing.Base.DP.RangeDP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-07-01 22:42 AcWing.Base.DP.RangeDP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A282 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/1 - the current system date.  22:42 - the current system time.  2023 - the current year.  07 - the current month.  01 - the current day of the month.  22 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */

public class A282 {
    //282. 石子合并
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //设有 N
    // 堆石子排成一排，其编号为 1,2,3,…,N
    //。
    //
    //每堆石子有一定的质量，可以用一个整数来描述，现在要将这 N
    // 堆石子合并成为一堆。
    //
    //每次只能合并相邻的两堆，合并的代价为这两堆石子的质量之和，合并后与这两堆石子相邻的石子将和新堆相邻，合并时由于选择的顺序不同，合并的总代价也不相同。
    //
    //例如有 4
    // 堆石子分别为 1 3 5 2， 我们可以先合并 1、2
    // 堆，代价为 4
    //，得到 4 5 2， 又合并 1、2
    // 堆，代价为 9
    //，得到 9 2 ，再合并得到 11
    //，总代价为 4+9+11=24
    //；
    //
    //如果第二步是先合并 2、3
    // 堆，则代价为 7
    //，得到 4 7，最后一次合并代价为 11
    //，总代价为 4+7+11=22
    //。
    //
    //问题是：找出一种合理的方法，使总的代价最小，输出最小代价。
    //
    //输入格式
    //第一行一个数 N
    // 表示石子的堆数 N
    //。
    //
    //第二行 N
    // 个数，表示每堆石子的质量(均不超过 1000
    //)。
    //
    //输出格式
    //输出一个整数，表示最小代价。
    //
    //数据范围
    //1≤N≤300
    //输入样例：
    //4
    //1 3 5 2
    //输出样例：
    //22


    //思路
    //区间DP
    //先枚举区间的长度
    //再枚举起点的位置
    //定义DP[i][j]的意义:合并从i到j所需要的最小代价，从1到n,包括[i,j]
    //递推公式
    //思考 每一组实际上都可以拆分为两个组合
    // i-k  k+1-j 选择两边的最小值
    // 加上合并左右两边的代价 s[j]-s[i-1]
    public static int[] stones;
    public static int[] s;
    public static int size=307;
    public static int dp[][];
    static int INF = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        stones=new int[size];
        s=new int[size];
        dp=new int[size][size];
        //读入数据
        for(int i=1;i<=N;i++){
            stones[i]=in.nextInt();
            //前缀和
            s[i]+=s[i-1]+stones[i];
        }
        //初始化动态规划数组
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],INF);
        }

        //先枚举区间长度 区间长度可以有哪些？
        //从1到n
        for(int len=1;len<=N;len++){

            //再考虑左端点的起步可以有哪些
            //从1到1+len正好等于N
            for(int i=1;i+len-1<=N;i++){
                int j=i+len-1; //右端点
                if(len==1){
                    dp[i][j]=0;
                    //长度为1 合并自己不需要cost
                }

                //最后枚举
                //在当前的i到j中
                //k可以有哪些？
                for(int k=i;k<=j-1;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+(s[j]-s[i-1]));
                }
            }
        }
        System.out.println(dp[1][N]);
    }


}
