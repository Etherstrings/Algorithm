package WorkReview.CralBook.Stack;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-17
 */
public class L215TopK {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> big = new PriorityQueue<>(
                (o1, o2) -> {
                    return o2 - o1;
                }
        );
        for (int n:nums) {
            big.offer(n);
        }
        for (int i=0;i<k;i++) {
            if (i==k-1) {
                return big.poll();
            }
            big.poll();
        }
        return 0;
    }
}
