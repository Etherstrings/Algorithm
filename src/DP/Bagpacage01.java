package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-26 10:49
 */
public class Bagpacage01 {
    //1.基础的背包问题
    //物品  取或者不取 两种状态
    //背包大小 固定
    //获取取了物品之后的最大值
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        packagevalue(weight, value, bagsize);
    }

    public static void packagevalue(int[] weight, int[] value, int bagsize){
        //初始化DP数组
        int[][] dp=new int[weight.length+1][bagsize+1];

        //DP数组的推导公式

        //当前i的状态---由上一个i-1得来
        //i由两种状态 i入包 i不入包

        //如果i不入包 那么当前的价值和上一个状态相同
        //dp[i][j]=dp[i-1][j]

        //如果i入包 那么当前的价值就要发生变化
        //dp[i][j]=dp[i-1][j-weight[i]]+value[i];


        //DP数组的初始条件
        //根据i以及j来划定初始条件
        //如果j==0 那就是物品一个都没法入包  dp[i][0]==0;
        //如果i==0 就要判断j>=0 这样才能保证 0号物品可以入包 dp[0][j]==value[0]
        for(int i=0;i<weight.length+1;i++){
            dp[i][0]=0;
        }


        for(int i=weight[0];i<=bagsize;i++){
            dp[0][i]=value[0];
        }
        //遍历顺序
        //先遍历物品 从0-i挨个取
        //再遍历背包 背包容量逐步增大
        for(int i=1;i<=weight.length;i++){
            for(int j=1;j<=bagsize;j++){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j]=Math.max(dp[i - 1][j],dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= weight.length; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void packagevalue1(){
        //滚动数组
        int[] dp=new int[5];

    }
}
