package ToBigFactory.DP;

public class L63 {
    public static void main(String[] args) {

    }
    public static int differentPath_II(int[][] gird){
        int[][] dp=new int[gird.length][gird[0].length];
        int index_down=0;
        int index_right=0;
        for(int i=0;i<gird.length;i++){
            if(gird[i][0]==1){
                index_down=i;
                break;
            }
        }
        for(int i=0;i<gird[0].length;i++){
            if(gird[0][i]==1){
                index_right=i;
                break;
            }
        }
        if(index_right!=0){
            for(int i=0;i<index_right;i++){
                dp[0][i]=1;
            }
            for(int i=index_right;i<gird[0].length;i++){
                dp[0][i]=0;
            }
        }else {
            for(int i=0;i<gird[0].length;i++){
                dp[0][i]=1;
            }
        }

        if(index_down!=0){
            for(int i=0;i<index_down;i++){
                dp[i][0]=1;
            }
            for(int i=index_down;i<gird.length;i++){
                dp[i][0]=0;
            }
        }else {
            for(int i=0;i<gird.length;i++){
                dp[i][0]=1;
            }
        }

        for(int i=1;i<gird.length;i++){
            for(int j=1;j<gird[0].length;j++){
                if(gird[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[gird.length-1][gird[0].length-1];
    }
}
