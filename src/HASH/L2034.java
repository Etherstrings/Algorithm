package HASH;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-08
 */
public class L2034 {
    //给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
    //
    //不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。
    //某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
    //
    //请你设计一个算法，实现：
    //
    //更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
    //找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
    //找到当前记录里股票的 最高价格 。
    //找到当前记录里股票的 最低价格 。
    //请你实现 StockPrice 类：
    //
    //StockPrice() 初始化对象，当前无股票价格记录。
    //void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
    //int current() 返回股票 最新价格 。
    //int maximum() 返回股票 最高价格 。
    //int minimum() 返回股票 最低价格 。
    //示例 1：
    //
    //输入：
    //["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
    //[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
    //输出：
    //[null, null, null, 5, 10, null, 5, null, 2]
    class StockPrice {
        HashMap<Integer,Integer> map;
        Queue<int[]> bigque;
        int current;
        int maximum;
        int minimum;
        public StockPrice() {
            map=new HashMap<>();
            current=0;
            maximum=Integer.MIN_VALUE;
            minimum=Integer.MAX_VALUE;
            //按照时间戳倒叙排列
            //{时间戳，价格}
            bigque=new PriorityQueue<>((x,y) -> (y[0]-x[0]));
        }

        public void update(int timestamp, int price) {
            if(map.containsKey(timestamp)){
                int old=map.get(timestamp);
                map.put(timestamp,price);
                Queue<int[]> temp=new PriorityQueue<>((x,y) -> (y[0]-x[0]));
                maximum=Integer.MIN_VALUE;
                minimum=Integer.MAX_VALUE;
                while(!bigque.isEmpty()){
                    int[] cur=bigque.poll();
                    if(cur[0]==timestamp){
                        cur[1]=price;
                    }
                    maximum=Math.max(maximum,cur[1]);
                    minimum=Math.min(minimum,cur[1]);
                    temp.add(cur);
                }
                bigque=temp;
                current=bigque.peek()[1];
            }else {
                map.put(timestamp,price);
                maximum=Math.max(maximum,price);
                minimum=Math.min(minimum,price);
                bigque.add(new int[]{timestamp,price});
                current=bigque.peek()[1];
            }
        }

        public int current() {
            return current;
        }

        public int maximum() {
            return maximum;
        }

        public int minimum() {
            return minimum;
        }
    }



}
