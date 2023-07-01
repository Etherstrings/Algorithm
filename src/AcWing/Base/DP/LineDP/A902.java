package AcWing.Base.DP.linedp;

import java.util.Scanner;

public class A902 {
    //902. 最短编辑距离
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定两个字符串 A
    // 和 B
    //，现在要将 A
    // 经过若干操作变为 B
    //，可进行的操作有：
    //
    //删除–将字符串 A
    // 中的某个字符删除。
    //插入–在字符串 A
    // 的某个位置插入某个字符。
    //替换–将字符串 A
    // 中的某个字符替换为另一个字符。
    //现在请你求出，将 A
    // 变为 B
    // 至少需要进行多少次操作。
    //
    //输入格式
    //第一行包含整数 n
    //，表示字符串 A
    // 的长度。
    //
    //第二行包含一个长度为 n
    // 的字符串 A
    //。
    //
    //第三行包含整数 m
    //，表示字符串 B
    // 的长度。
    //
    //第四行包含一个长度为 m
    // 的字符串 B
    //。
    //
    //字符串中均只包含大小写字母。
    //
    //输出格式
    //输出一个整数，表示最少操作次数。
    //
    //数据范围
    //1≤n,m≤1000
    //输入样例：
    //10
    //AGTCTGACGC
    //11
    //AGTAAGTAGGC
    //输出样例：
    //4
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer n=Integer.parseInt(in.nextLine().replace(" ",""));
        String A=in.nextLine();
        Integer m=Integer.parseInt(in.nextLine().replace(" ",""));
        String B=in.nextLine();
        System.out.println(criddist(A,B));
    }
    public static int criddist(String A,String B){
        int m=A.length();int n=B.length();
        int[][] dp=new int[m+1][n+1];

        //明确dp数组的含义
        //dp[i][j]表示 使得下标为i-1的字符串A 和 下标为j-1的字符串B 相同的最小编辑次数

        //确定递推的关系
        //有哪几种处理方式
        //怎么来的？
        //DP[i][j] 加了一个j 即i-1
        //DP[i][j] 加了一个i 即j-1

        //初始化[0][0]=0;
        //[i][0] 删掉所有的i
        //[0][j] 删掉所有的j
        for(int i=1;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<n+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }

    public static int getans(String word1,String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
