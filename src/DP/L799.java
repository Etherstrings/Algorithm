package DP;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-08
 */
public class L799 {
    //大名鼎鼎香槟塔
    //dp[i][j]表示前i层，j个香槟塔的最大高度
    public static double champagneTower(int poured, int query_row, int query_glass) {
        //poured为倒入的香槟
        //query_row为第几层
        //query_glass为第几个杯子
        //dp[i][j]表示第i层第j个杯子的香槟量
        double[][] dp=new double[102][102];
        dp[1][1]=poured;
        //能从哪里来？ 头顶和左上
        for(int i=2;i<=query_row+1;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=Math.max(0,dp[i-1][j-1]-1)/2+Math.max(0,dp[i-1][j]-1)/2;
            }
        }
        return Math.min(1,dp[query_row+1][query_glass+1]);
    }
}
