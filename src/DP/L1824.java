package DP;

/**
 * @author Justice_wby
 * @create 2023-01-21 10:19
 */
public class L1824 {
    //1824. 最少侧跳次数
    //给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
    //
    //给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
    //
    //比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
    //这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
    //
    //比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
    //这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
    //
    //注意：点 0 处和点 n 处的任一跑道都不会有障碍。
    public int minSideJumps(int[] obstacles) {
        //青蛙到达i号点的j号跑道需要的最小跳跃次数
        int len = obstacles.length;
        int[][] dp = new int[3][len];

        dp[0][0] = dp[2][0] = 1;

        for(int i = 1; i < len; i++){
            //当前阻塞的是哪个道路
            //如果是-1 没有阻塞
            int obsWay = obstacles[i] - 1 ;
            if(obsWay != -1) dp[obsWay][i-1] = 3 * len;
            dp[0][i] = Math.min(dp[0][i-1],Math.min(dp[1][i-1],dp[2][i-1]) + 1);
            dp[1][i] = Math.min(dp[1][i-1],Math.min(dp[0][i-1],dp[2][i-1]) + 1);
            dp[2][i] = Math.min(dp[2][i-1],Math.min(dp[0][i-1],dp[1][i-1]) + 1);
            if(obsWay != -1) dp[obsWay][i] = 3 * len;
        }
        return Math.min(dp[0][len-1],Math.min(dp[1][len-1],dp[2][len-2]));
    }

}
