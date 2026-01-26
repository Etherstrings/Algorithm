package WorkReview.CralBook.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-17
 */
public class L347TopKShowUp {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> big = new PriorityQueue<>(
                (o1, o2) -> o2[1]-o1[1]
        );
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (Entry<Integer,Integer> entry : map.entrySet()) {
            big.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = big.poll()[0];
        }
        return ans;
    }
}
