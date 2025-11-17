package TanXin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-22
 */
public class L1481 {
    //给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。

    //> 2023/11/22 19:56:32
    //解答成功:
    //	执行耗时:54 ms,击败了33.33% 的Java用户
    //	内存消耗:55.6 MB,击败了45.93% 的Java用户
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        // 优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int ans = map.size();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        while(k > 0) {
            int[] now = queue.poll();
            if (k >= now[1]) {
                k -= now[1];
                ans--;
            } else {
                break;
            }
        }
        return ans;
    }
}
