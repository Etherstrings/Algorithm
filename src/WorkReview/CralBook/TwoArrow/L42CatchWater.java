package WorkReview.CralBook.TwoArrow;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-22
 */
public class L42CatchWater {



    //思路 每一个柱子，维护当前自己能接的水
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 0 ;i<height.length;i++) {
            if (i==0 || i==height.length-1) {
                continue;
            }
            int lH = 0;
            int rH = 0;
            for (int j=i-1;j>=0;j--) {
                lH = Math.max(height[j], lH);
            }
            for (int j=i+1;j<height.length;j++) {
                rH = Math.max(rH,height[j]);
            }
            int value = Math.min(lH, rH) - height[i];
            if (value > 0) {
                ans+=value;
            }
        }
        return ans;
    }



    public int trapAnswer(int[] height) {
        int[][] dp = new int[height.length][2];
        int lMax = height[0];
        for (int i=0;i<height.length;i++) {
            if (i == 0) {
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],height[i-1]);
        }
        for (int i=height.length-1;i>=0;i--) {
            if (i == height.length-1) {
                continue;
            }
            dp[i][1] = Math.max(dp[i+1][1],height[i+1]);
        }
        int ans = 0;
        for (int i=1;i<height.length-1;i++) {
            int value = Math.min(dp[i][0],dp[i][1]) - height[i];
            if (value > 0) {
                ans += value;
            }
        }
        return ans;
    }


    public int trap1(int[] height) {
        //分别维护左侧和右侧最大值
        int[][] dp = new int[height.length][2];
        for (int i=1;i<height.length;i++) {
            dp[i][0] = Math.max(dp[i-1][0],height[i-1]);
        }
        for (int i=height.length-1-1;i>=0;i--) {
            dp[i][1] = Math.max(dp[i+1][1],height[i+1]);
        }
        int ans = 0;
        for (int i=1;i<height.length-1;i++) {
            int now = Math.min(dp[i][0],dp[i][1])-height[i];
            if (now>0) {
                ans+=now;
            }
        }
        return ans;
    }
}
