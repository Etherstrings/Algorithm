package AcWing.Base.DP.linedp;

import java.util.Scanner;

public class A899 {
    //给定 n
    // 个长度不超过 10
    // 的字符串以及 m
    // 次询问，每次询问给出一个字符串和一个操作次数上限。
    //
    //对于每次询问，请你求出给定的 n
    // 个字符串中有多少个字符串可以在上限操作次数内经过操作变成询问给出的字符串。
    //
    //每个对字符串进行的单个字符的插入、删除或替换算作一次操作。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 n
    // 行，每行包含一个字符串，表示给定的字符串。
    //
    //再接下来 m
    // 行，每行包含一个字符串和一个整数，表示一次询问。
    //
    //字符串中只包含小写字母，且长度均不超过 10
    //。
    //
    //输出格式
    //输出共 m
    // 行，每行输出一个整数作为结果，表示一次询问中满足条件的字符串个数。
    //
    //数据范围
    //1≤n,m≤1000
    //,
    //
    //输入样例：
    //3 2
    //abc
    //acd
    //bcd
    //ab 1
    //acbd 2
    //输出样例：
    //1
    //3
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int n=Integer.parseInt(line1[0].replace(" ",""));
        int m=Integer.parseInt(line1[1].replace(" ",""));
        //每次询问
        String[] words=new String[n];
        for(int i=0;i<n;i++){
            words[i]=in.nextLine().replace(" ","");
        }
        //每次询问
        for(int i=0;i<m;i++){
            String[] line=in.nextLine().split(" ");
            String query=line[0];
            int k=Integer.parseInt(line[1].replace(" ",""));
            System.out.println(getquery(words,query,k));
        }
    }

    public static int getquery(String[] words,String query,int k){
        int ans=0;
        for(String word:words){
            if(criddist(word,query)<=k){
                ans++;
            }
        }
        return ans;
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
}
