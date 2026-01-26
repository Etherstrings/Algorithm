package WorkReview.CralBook.Moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L189 {
    public void rotate(int[] nums, int k) {
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //用队列解决
        java.util.Queue<Integer> que = new java.util.LinkedList<>();
        for (int n:nums) {
            que.offer(n);
        }
        for (int i = 0; i < k; i++) {
            que.offer(que.poll());
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = que.poll();
        }
    }
}
