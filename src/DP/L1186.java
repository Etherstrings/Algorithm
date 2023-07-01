package DP;

public class L1186 {
    //1186. 删除一次得到子数组最大和
    //给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
    //
    //注意，删除一个元素后，子数组 不能为空。
    //
    //
    //
    //示例 1：
    //
    //输入：arr = [1,-2,0,3]
    //输出：4
    //解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
    //示例 2：
    //
    //输入：arr = [1,-2,-2,3]
    //输出：3
    //解释：我们直接选出 [3]，这就是最大和。
    //示例 3：
    //
    //输入：arr = [-1,-1,-1,-1]
    //输出：-1
    //解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
    //     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。

    public static int maximumSum(int[] arr) {
        //首先明确dp数组的含义
        //dp[i][j] 表示子数组的右端点为i时，不能/必须删除数字时的，子数组的最大值
        //0 不能删除
        //1 必须删除
        int ans=arr[0];
        int[][] dp=new int[arr.length][2];
        dp[0][0]=dp[0][1]=arr[0];
        for(int i=1;i<dp.length;i++){
            //不能删除
            //选不选i左边的数？
            //不选 那么就考虑i是不是大于0就行
            //选 既然考虑选左边的，那就是arr[i]肯定加上了
            dp[i][0]=Math.max(dp[i-1][0],0)+arr[i];

            //必须删一个
            //选不选i左边的数？
            //不选 那就删arr[i]
            //选 那就是左边的删了的加上arr[i]
            dp[i][1]=Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
            ans=Math.max(Math.max(dp[i][0],dp[i][1]),ans);
        }
        return ans;
    }
}
