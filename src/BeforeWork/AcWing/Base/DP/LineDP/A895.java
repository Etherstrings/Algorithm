package AcWing.Base.DP.linedp;

import java.util.Arrays;
import java.util.Scanner;

//895. 最长上升子序列
//   题目
//   提交记录
//   讨论
//   题解
//   视频讲解
//
//给定一个长度为 N
// 的数列，求数值严格单调递增的子序列的长度最长是多少。
//
//输入格式
//第一行包含整数 N
//。
//
//第二行包含 N
// 个整数，表示完整序列。
//
//输出格式
//输出一个整数，表示最大长度。
//
//数据范围
//1≤N≤1000
//，
//−109≤数列中的数≤109
//输入样例：
//7
//3 1 2 1 8 5 6
//输出样例：
//4
public class A895 {
    /**
     *
     */
    public static int len=1010;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int[] dp = new int[len];
        int[] nums = new int[len];
        for (int i = 1; i <= N; i++) {
            nums[i] = in.nextInt();
        }
        //dp[i]=Math.max(dp[i],dp[j]+1);
        int ans=Integer.MIN_VALUE;
        Arrays.fill(dp,1);
        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(dp[i],ans);
        }
        System.out.println(ans);
    }
}
