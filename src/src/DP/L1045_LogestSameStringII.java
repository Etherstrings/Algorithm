package src.DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-01 17:41
 */
public class L1045_LogestSameStringII {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //核心思路是什么？
        //明白一点
        //那就是只要相对位置相同----就不会相交

        //因此变成了
        //A B两个字符串 所拥有的的相同最大字串
        int[][] dp=new int[nums1.length+1][nums2.length+1];

        for(int i=1;i<nums1.length+1;i++){
            for(int j=1;j<nums2.length+1;j++){
                if(nums1[i-1]==nums2[i-1]){
                    dp[i][j]=dp[i-1][j-1]+1;

                }else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

}
