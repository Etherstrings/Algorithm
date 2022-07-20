package TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-12 21:37 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L122 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/12 - the current system date.  21:37 - the current system time.  2022 - the current year.  07 - the current month.  12 - the current day of the month.  21 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L122 {
    //122. 买卖股票的最佳时机 II
    //给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
    //
    //在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
    //
    //返回 你能获得的 最大 利润 。
    //
    //
    //
    //示例 1：
    //
    //输入：prices = [7,1,5,3,6,4]
    //输出：7
    //解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    //     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
    //     总利润为 4 + 3 = 7 。
    //示例 2：
    //
    //输入：prices = [1,2,3,4,5]
    //输出：4
    //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    //     总利润为 4 。
    //示例 3：
    //
    //输入：prices = [7,6,4,3,1]
    //输出：0
    //解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
    public int maxProfit(int[] prices) {
        //思路
        //怎么获得呢？
        //低价买入 高价卖出
        //贪心 怎么贪 每次都卖
        //每天都可以购买 卖出
        //将利润拆解
        if(prices.length==1){
            return 0;
        }
        int sum=0;
        for(int i=1;i<prices.length;i++){
            int temp=prices[i]-prices[i-1];
            if(temp>0){
                sum+=temp;
            }
        }
        return sum;
    }
}
