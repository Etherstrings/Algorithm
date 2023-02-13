package src;

/**
 * @author Etherstrings
 * @create 2022-06-13 15:00 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L121_BuyStockI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/13 - the current system date.  15:00 - the current system time.  2022 - the current year.  06 - the current month.  13 - the current day of the month.  15 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L121 {
    //121. 买卖股票的最佳时机

    //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //
    //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //
    //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    //
    // 
    //
    //示例 1：
    //
    //输入：[7,1,5,3,6,4]
    //输出：5
    //解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
    //示例 2：
    //
    //输入：prices = [7,6,4,3,1]
    //输出：0
    //解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
    public int maxProfit(int[] prices) {
        //思路
        //1.先判断这只股票是不是一直在跌
        //  是---那就卖不出去
        //  否---那就有利润存在
        if(prices.length==1){
            return 0;
        }
        boolean Flag=true;

        for(int i=1;i<prices.length;i++){
            if(prices[i-1]>=prices[i]){
                continue;
            }else {
                Flag=false;
            }
        }
        if(Flag){
            return 0;
        }

        int money=0;
        for(int i=0;i<prices.length-1;i++){
            //从第一天开始挨个取
            //假如n买入如何？
            for(int j=i+1;j<prices.length;j++){
                //从N+1天判断差值
                if(prices[j]>prices[i]){
                    //可以尝试卖出
                    money=Math.max(money,(prices[j]-prices[i]));
                }else {
                    continue;
                }
            }
        }
        return money;

    }

    public int maxProfit1(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        //如果第一天买 那么现在的利润为0
        int min = prices[0], max = 0;

        for(int i = 1; i < prices.length; i++) {

            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }


}
