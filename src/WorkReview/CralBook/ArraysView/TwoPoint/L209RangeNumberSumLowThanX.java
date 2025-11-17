package WorkReview.CralBook.ArraysView.TwoPoint;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-17
 */
public class L209RangeNumberSumLowThanX {
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //
    //找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    //
    //示例 1：
    //
    //输入：target = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    //示例 2：
    //
    //输入：target = 4, nums = [1,4,4]
    //输出：1
    //示例 3：
    //
    //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    //输出：0
    //提示：
    //
    //1 <= target <= 109
    //1 <= nums.length <= 105
    //1 <= nums[i] <= 104
    //进阶：
    //
    //如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

    /**
     * 维护一个左右区间，这个区间内的值大于等于这个sum，不需要考虑区间内的大小顺序，因为一定会被包含，所以只需要维护左右位置和一个历史长度
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 0;
        int sum = 0;
        //加完之后再做操作 加之前操作
        //加之前进来的都是小于的
        for (;fast<nums.length;) {
            sum += nums[fast];
            for (;sum >= target;) {
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
