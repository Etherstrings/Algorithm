package src.DP;

/**
 * @author Etherstrings
 * @create 2022-07-26 20:00 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1049 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/26 - the current system date.  20:00 - the current system time.  2022 - the current year.  07 - the current month.  26 - the current day of the month.  20 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1049 {
    //1049. 最后一块石头的重量 II
    //有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
    //
    //每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
    //
    //如果 x == y，那么两块石头都会被完全粉碎；
    //如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    //最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
    //
    // 
    //
    //示例 1：
    //
    //输入：stones = [2,7,4,1,8,1]
    //输出：1
    //解释：
    //组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
    //组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
    //组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
    //组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
    //示例 2：
    //
    //输入：stones = [31,26,33,21,40]
    //输出：5
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int a:stones){
            sum+=a;
        }

        int target=sum/2;

        int[] dp=new int[target+1];

        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum-2*dp[target];
    }

}
