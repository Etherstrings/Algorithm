package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-01 14:16
 */
public class L718_LongestStringTwoArray {
    //718. 最长重复子数组
    //给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    //输出：3
    //解释：长度最长的公共子数组是 [3,2,1] 。
    //示例 2：
    //
    //输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    //输出：5
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。 （特别注意： “以下标i - 1为结尾的A” 标明一定是 以A[i-1]为结尾的字符串 ）
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=0;i< nums1.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<nums2.length;i++){
            dp[0][i]=0;
        }
        int res=0;
        for(int i=1;i<nums1.length+1;i++){
            for(int j=1;j<nums2.length+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(dp[i][j],res);
                }
            }
        }
        return res;


    }
}
