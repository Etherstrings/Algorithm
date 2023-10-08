package DP;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-27
 */
public class L174 {
    //恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
    //
    //骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
    //
    //有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
    //
    //为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。
    //
    //返回确保骑士能够拯救到公主所需的最低初始健康点数。
    //
    //注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。

    //反向DP

    //结果
    //> 2023/10/07 11:49:01
    //已提交,请稍等
    //
    //> 2023/10/07 11:49:01
    //解答成功:
    //	执行耗时:1 ms,击败了86.48% 的Java用户
    //	内存消耗:42.8 MB,击败了24.86% 的Java用户
    public int calculateMinimumHP(int[][] dungeon) {
        //如果我从左上角到右下角 肯定不行
        //但是我从右下角到左上角 可以思考一下
        //dp[i][j] 表示从i,j到终点所需要的最小血量
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        //初始化
        //右下角的公主房间可能也有问题，要注意，所以这里初始化
        //全程要大于1，如果公主房间为负数，那就应该初始化为1-公主房间的值
        //如果公主房间为正数，那就初始化为1
        if(dungeon[dungeon.length - 1][dungeon[0].length - 1] < 0){
            dp[dungeon.length - 1][dungeon[0].length - 1] = 1 - dungeon[dungeon.length - 1][dungeon[0].length - 1];
        }
        else{
            dp[dungeon.length - 1][dungeon[0].length - 1] = 1;
        }
        //初始化最后一行
        for(int i = dungeon[0].length - 2;i >= 0;i--){
            if(dungeon[dungeon.length - 1][i] < 0){
                //如果我当前的是需要减去，那我最小的通过值就是我右边的值减去我当前的值
                dp[dungeon.length - 1][i] = dp[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i];
            }
            else{
                //如果当前房间的值为正数，那就肯定能过，我需要保持我能够到达终点
                dp[dungeon.length - 1][i] = Math.max(dp[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i],1);
            }
        }
        //初始化最后一列
        for(int i = dungeon.length - 2;i >= 0;i--){
            dp[i][dungeon[0].length - 1] = Math.max(dp[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1],1);
        }
        for(int i= dungeon.length -2;i >= 0; i--){
            for( int j = dungeon[0].length - 2;j >= 0;j--){
                //便利顺序 往左 往上
                //时刻注意，我一定是需要能够到达重点的情况下的最小值
                //因此我的来源是来自于我右边的值和我下边的值
                dp[i][j] = Math.max(Math.min(dp[i + 1][j],dp[i][j + 1]) - dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
