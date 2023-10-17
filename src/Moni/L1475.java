package Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-13
 */
public class L1475 {

    //> 2023/10/13 15:56:16
    //解答成功:
    //	执行耗时:1 ms,击败了98.19% 的Java用户
    //	内存消耗:42.2 MB,击败了92.55% 的Java用户

    //商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
    //
    //请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
    //
    //示例 1：
    //
    //输入：prices = [8,4,6,2,3]
    //输出：[4,2,4,2,3]
    //解释：
    //商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
    //商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
    //商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
    //商品 3 和 4 都没有折扣。
    //示例 2：
    //
    //输入：prices = [1,2,3,4,5]
    //输出：[1,2,3,4,5]
    //解释：在这个例子中，所有商品都没有折扣。

    public static int[] finalPrices(int[] prices) {
        int[] reduce = new int[prices.length];
        int[] ans=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            if(i==prices.length-1){
                reduce[i]=0;
            }
            int nowP=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=nowP){
                    reduce[i]=prices[j];
                    break;
                }
            }
            ans[i]=prices[i]-reduce[i];
        }
        return ans;
    }
}
