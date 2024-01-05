package TanXin;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-29
 */
public class L2448 {
    //给你两个下标从 0 开始的数组 nums 和 cost ，分别包含 n 个 正 整数。
    //
    // 你可以执行下面操作 任意 次：
    //
    //
    // 将 nums 中 任意 元素增加或者减小 1 。
    //
    //
    // 对第 i 个元素执行一次操作的开销是 cost[i] 。
    //
    // 请你返回使 nums 中所有元素 相等 的 最少 总开销。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：nums = [1,3,5,2], cost = [2,3,1,14]
    //输出：8
    //解释：我们可以执行以下操作使所有元素变为 2 ：
    //- 增加第 0 个元素 1 次，开销为 2 。
    //- 减小第 1 个元素 1 次，开销为 3 。
    //- 减小第 2 个元素 3 次，开销为 1 + 1 + 1 = 3 。
    //总开销为 2 + 3 + 3 = 8 。
    //这是最小开销。
    //
    //
    // 示例 2：
    //
    //
    //输入：nums = [2,2,2,2,2], cost = [4,2,8,1,3]
    //输出：0
    //解释：数组中所有元素已经全部相等，不需要执行额外的操作。
    //
    //
    //
    //
    // 提示：
    //
    //
    // n == nums.length == cost.length
    // 1 <= n <= 10⁵
    // 1 <= nums[i], cost[i] <= 10⁶
    // 测试用例确保输出不超过 2⁵³-1。
    //
    //
    // Related Topics 贪心 数组 二分查找 前缀和 排序 👍 39 👎 0
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        Integer[] idxs = new Integer[n];
        long sum = 0L;
        for(int i = 0; i < n; i++) {
            idxs[i] = i; sum += cost[i];
        }
        // 按照 nums[i] 的大小进行升序排序  // 求解中位数
        Arrays.sort(idxs, (a, b) -> nums[a] - nums[b]);
        int target = 0;
        long cur = 0L;
        for(int i = 0; i < n; i++) {
            cur += cost[idxs[i]];
            if (cur >= sum / 2) {
                target = nums[idxs[i]];
                break;
            }
        }
        for(int i=0;i<n;i++){
            sum += Math.abs(target - nums[i])*cost[i];
        }
        return sum;
    }
}
