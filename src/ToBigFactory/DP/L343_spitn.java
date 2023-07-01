package ToBigFactory.DP;

public class L343_spitn {
    public static void main(String[] args) {
        System.out.println(spit(10));
    }

    public static int spit(int n){
        //拆分数字n可以获取的最大乘积
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=n;i++){
            for(int j=1;j<4;j++){
                dp[i]=Math.max(Math.max(dp[i],(j)*dp[i-j]),(i-j)*j);
            }
        }
        return dp[n];
    }
}
