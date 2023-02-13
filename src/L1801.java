import java.util.*;

public class L1801 {
    //1801. 积压订单中的订单总数
    //给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
    //
    //订单类型 orderTypei 可以分为两种：
    //
    //0 表示这是一批采购订单 buy
    //1 表示这是一批销售订单 sell
    //注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
    //
    //存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
    //
    //如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
    //反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
    //输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
    //
    //



    //  53 / 69 个通过测试用例
    public int getNumberOfBacklogOrders(int[][] orders) {
        // 价格 数量 类型
        // 0 buy
        // 1 sell
        // buy---从sell的订单里找最低的
        // sell---从buy订单里找最高的
        final int MOD = 1000000007;
        HashMap<Integer,Integer> buymap=new HashMap<>();
        HashMap<Integer,Integer> sellmap=new HashMap<>();

        Set<Integer> buyset=new HashSet<>();
        Set<Integer> sellset=new HashSet<>();

        //采购订单里找最高的
        Queue<Integer> buylist = new PriorityQueue<>((x, y) -> (y - x));
        //销售的订单里找最低的
        Queue<Integer> selllist = new PriorityQueue<>((x, y) -> (x - y));

        for(int i=0;i<orders.length;i++){
            int type=orders[i][2];
            int amount=orders[i][1];
            int price=orders[i][0];
            if(i==0){
                if(type==0){
                    //此时为购买的清单
                    buymap.put(price,amount);
                    buyset.add(price);
                    buylist.add(price);
                }else {
                    //此时为销售的清单
                    sellmap.put(price,amount);
                    sellset.add(price);
                    selllist.add(price);
                }
                continue;
            }
            if(type==0){
                //此时为购买的清单
                //从销售的订单里找最低的
                //消耗订单
                boolean falg=true;
                while(falg){
                    if(selllist.isEmpty()){
                        falg=false;
                        break;
                    }
                    int now=selllist.peek();
                    if(now>price){
                        falg=false;
                        break;
                    }
                    if(amount==0){
                        //卖完了
                        falg=false;
                        break;
                    }
                    int nowleft=sellmap.get(now);
                    if(nowleft<=amount){
                        //当前的货物不够
                        //这个货物完全消耗
                        amount-=nowleft;
                        sellmap.remove(now);
                        sellset.remove(now);
                        selllist.poll();
                        continue;
                    }else {
                        //当前货物足够
                        nowleft-=amount;
                        amount=0;
                        sellmap.put(now,nowleft);
                    }
                }
                //存储订单
                buyset.add(price);
                buylist.offer(price);
                if(buymap.containsKey(price)){
                    buymap.put(price,buymap.get(price)+amount);
                }else {
                    buymap.put(price,amount);
                }

            }else {
                //此时为销售的清单
                //从购买的订单里找最高的
                //消耗订单
                boolean falg=true;
                while(falg){
                    if(buylist.isEmpty()){
                        falg=false;
                        break;
                    }
                    int now=buylist.peek();
                    if(now<price){
                        falg=false;
                        break;
                    }
                    if(amount==0){
                        //卖完了
                        falg=false;
                        break;
                    }
                    int nowleft=buymap.get(now);
                    if(nowleft<=amount){
                        //当前的货物不够
                        //这个货物完全消耗
                        amount-=nowleft;
                        buymap.remove(now);
                        buyset.remove(now);
                        buylist.poll();
                        continue;
                    }else {
                        //当前货物足够
                        nowleft-=amount;
                        amount=0;
                        buymap.put(now,nowleft);
                    }
                }
                //存储订单
                sellset.add(price);
                selllist.offer(price);
                if(sellmap.containsKey(price)){
                    sellmap.put(price,sellmap.get(price)+amount);
                }else {
                    sellmap.put(price,amount);
                }
            }
        }
        int total = 0;
        for(int now:sellset){
            total+=sellmap.get(now);
        }
        for(int now:buyset){
            total+=buymap.get(now);
        }
        return total%MOD;

    }


    //官方题解
    public int getNumberOfBacklogOrdersGov(int[][] orders) {
            final int MOD = 1000000007;
            PriorityQueue<int[]> buyOrders = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            PriorityQueue<int[]> sellOrders = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            for (int[] order : orders) {
                int price = order[0], amount = order[1], orderType = order[2];
                if (orderType == 0) {
                    while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {
                        int[] sellOrder = sellOrders.poll();
                        int sellAmount = Math.min(amount, sellOrder[1]);
                        amount -= sellAmount;
                        sellOrder[1] -= sellAmount;
                        if (sellOrder[1] > 0) {
                            sellOrders.offer(sellOrder);
                        }
                    }
                    if (amount > 0) {
                        buyOrders.offer(new int[]{price, amount});
                    }
                } else {
                    while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                        int[] buyOrder = buyOrders.poll();
                        int buyAmount = Math.min(amount, buyOrder[1]);
                        amount -= buyAmount;
                        buyOrder[1] -= buyAmount;
                        if (buyOrder[1] > 0) {
                            buyOrders.offer(buyOrder);
                        }
                    }
                    if (amount > 0) {
                        sellOrders.offer(new int[]{price, amount});
                    }
                }
            }
            int total = 0;
            for (PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)) {
                while (!pq.isEmpty()) {
                    int[] order = pq.poll();
                    total = (total + order[1]) % MOD;
                }
            }
            return total;
        }

}
