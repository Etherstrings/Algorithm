package src.TanXin;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-22 09:46
 */
public class L714 {
    //买卖股票的最佳时机含手续费
    //Category	Difficulty	Likes	Dislikes
    //algorithms	Medium (74.07%)	755	-
    //Tags
    //Companies
    //给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
    //
    //你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    //
    //返回获得利润的最大值。
    //
    //注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
    //
    //
    //
    //示例 1：
    //
    //输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
    //输出：8
    //解释：能够达到的最大利润:
    //在此处买入 prices[0] = 1
    //在此处卖出 prices[3] = 8
    //在此处买入 prices[4] = 4
    //在此处卖出 prices[5] = 9
    //总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
    //示例 2：
    //
    //输入：prices = [1,3,7,5,10,3], fee = 3
    //输出：6

    public int maxProfit(int[] prices, int fee) {
        int buy=prices[0]+fee;
        int sum=0;
        for(int p:prices){
            if(p+fee<buy){
                buy=p+fee;
            }else if(p>buy){
                sum+=p-buy;
                buy=p;
            }
        }
        return sum;
    }

}
