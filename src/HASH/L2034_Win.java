package HASH;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-08
 */
public class L2034_Win {
    //> 2023/10/08 11:02:57
    //已提交,请稍等
    //
    //> 2023/10/08 11:02:58
    //解答成功:
    //	执行耗时:110 ms,击败了67.37% 的Java用户
    //	内存消耗:102.8 MB,击败了42.11% 的Java用户
    class StockPrice {

        /**
         * 记录时间戳到价格的映射
         */
        private Map<Integer, Integer> map;

        /**
         * 记录某个价格出现过几次
         * 可以方便地返回最大价格和最小价格
         */
        private TreeMap<Integer, Integer> treeMap;

        /**
         * 记录最大的时间戳
         */
        private int maxTimestamp;

        public StockPrice() {
            this.map = new HashMap<>();
            this.treeMap = new TreeMap<>();
            this.maxTimestamp = 0;
        }

        public void update(int timestamp, int price) {
            // 记录新时间戳到价格的映射
            Integer oldPrice = map.put(timestamp, price);

            // 如果存在旧价格，则旧价格的次数减一
            // 如果旧价格只出现过一次，直接移除
            if (oldPrice != null) {
                int oldCount = treeMap.get(oldPrice);
                if (oldCount == 1) {
                    treeMap.remove(oldPrice);
                } else {
                    treeMap.put(oldPrice, oldCount - 1);
                }
            }

            // 更新新价格的次数
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);

            // 记录最大时间戳
            if (timestamp > maxTimestamp) {
                maxTimestamp = timestamp;
            }
        }

        public int current() {
            return map.get(maxTimestamp);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }
}
