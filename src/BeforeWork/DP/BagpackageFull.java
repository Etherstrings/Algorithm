package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-27 17:19
 */
public class BagpackageFull {
    //完全背包问题
    //每个物品可以无限取

    //核心在哪里不同？
    //在于对于背包的遍历顺序 顺序
    public static void main(String[] args) {
        //先遍历物品 再背包
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagWeight=4;

        int[] dp=new int[bagWeight+1];

        for(int i=0;i<weight.length;i++){
            for(int j=weight[i];j<=bagWeight;j++){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
    }
}
