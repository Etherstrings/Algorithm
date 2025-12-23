package xiaohongshu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-23
 */
public class L239MaxValueInWindow {
    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new L239MaxValueInWindow().maxSlidingWindow(nums, k);
        //[3,3,5,5,6,7] 打印ints
        for (int anInt : ints) {
            System.out.print(anInt + "");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> b[1]-a[1] );
        //8 6 3
        int[] ans = new int[nums.length - k + 1];
        for (int i=0;i<k;i++) {
            queue.offer(new int[]{i,nums[i]});
        }
        ans[0] = queue.peek()[1];
        for (int i = k;i<nums.length;i++) {
            int index = i-k+1;
            queue.offer(new int[]{i,nums[i]});
            while (queue.peek()[0] < i-k+1) {
                queue.poll();
            }
            ans[index] = queue.peek()[1];
        }
        return ans;
    }
}
