package ToBigFactory.DP;

public class L746_climbwihtlowprice {
    public static void main(String[] args) {
        System.out.println(getprice(new int[]{10,15,20}));
    }

    public static int getprice(int[] costs){
        //dp[n] 爬上当前楼梯花费的最小花费

        //爬一个或者俩
        int[] dp=new int[costs.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=costs.length;i++){
            dp[i]=Math.min(dp[i-1]+costs[i-1],dp[i-2]+costs[i-2]);
        }
        return dp[costs.length];
    }
}
