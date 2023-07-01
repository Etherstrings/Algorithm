package AcWing.Base.DP.linedp;


import java.util.Scanner;

//897. 最长公共子序列
//   题目
//   提交记录
//   讨论
//   题解
//   视频讲解
//
//给定两个长度分别为 N
// 和 M
// 的字符串 A
// 和 B
//，求既是 A
// 的子序列又是 B
// 的子序列的字符串长度最长是多少。
//
//输入格式
//第一行包含两个整数 N
// 和 M
//。
//
//第二行包含一个长度为 N
// 的字符串，表示字符串 A
//。
//
//第三行包含一个长度为 M
// 的字符串，表示字符串 B
//。
//
//字符串均由小写字母构成。
//
//输出格式
//输出一个整数，表示最大长度。
//
//数据范围
//1≤N,M≤1000
//输入样例：
//4 5
//acbd
//abedc
//输出样例：
//3
public class A897 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int N=Integer.parseInt(line1[0]);
        int M=Integer.parseInt(line1[1]);
        String A=in.nextLine();
        String B=in.nextLine();
        System.out.println(getMaxSub(A,B));

    }

    public static int getMaxSub(String A,String B){
        int N=A.length();
        int M=B.length();
        int[][] dp=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }
}
