package WorkReview.CralBook.ArraysView.PreSum;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-27
 */
public class L3381 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;
        System.out.println(maxSubarraySum(nums, k));
    }
    public static long maxSubarraySum(int[] nums, int k) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int times = nums.length / k;
        Long max = Long.MIN_VALUE;
        for (int i = 0;i<times;i++) {
            int range = k*(i+1);
            if (range == 1) {
                continue;
            }
            for (int j = 0;j<nums.length-range+1;j++) {
                if (preSum[j+range] - preSum[j] > max) {
                    max = preSum[j+range] - preSum[j];
                }
            }
        }
        return max;
    }
}
