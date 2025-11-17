package DP;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-27 16:49
 */
public class L474 {
    //474. 一和零
    //给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    //
    //请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
    //
    //如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    //
    //
    //
    //示例 1：
    //
    //输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
    //输出：4
    //解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
    //其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
    //示例 2：
    //
    //输入：strs = ["10", "0", "1"], m = 1, n = 1
    //输出：2
    //解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
    public int findMaxForm(String[] strs, int m, int n) {
        //strs里面就是物品---m和n是两个背包

        //1.dp数组意义
            //最多有i个0 个 j个1 的 strs的最大子集的大小

        //2.递推公式
            //等于当前的减去 当前遍历到的子集里含有的0的个数 当前子集中遍历到的1的个数 再加1---这个能入包
            //入不了包---还是本身的这个
        int[][] dp=new int[m+1][n+1];

        for(String str:strs){
            //当前遍历到的字符串
            int zeronum=0;
            int onenum=0;
            for(char ch:str.toCharArray()){
                if(ch=='0'){
                    zeronum++;
                }else {
                    onenum++;
                }
            }
            for(int i=m;i>=zeronum;i--){
                for(int j=n;j>=onenum;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeronum][j-onenum]+1);
                }
            }
        }
        return dp[m][n];
    }
}
