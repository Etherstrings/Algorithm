package WorkReview.CralBook.ArraysView.TwoPoint;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-17
 */
public class L977RightAndLeftToMid {
    //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    //
    //示例 1：
    //
    //输入：nums = [-4,-1,0,3,10]
    //输出：[0,1,9,16,100]
    //解释：平方后，数组变为 [16,1,0,9,100]
    //排序后，数组变为 [0,1,9,16,100]
    //示例 2：
    //
    //输入：nums = [-7,-3,2,3,11]
    //输出：[4,9,9,49,121]
    //提示：
    //
    //1 <= nums.length <= 104
    //-104 <= nums[i] <= 104
    //nums 已按 非递减顺序 排序
    //进阶：
    //
    //请你设计时间复杂度为 O(n) 的算法解决本问题

    /**
     * 思路：左右双指针逼近中间，不换位就继续
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = nums.length - 1;
        int[] answer = new int[nums.length];
        while (l != r) {
            int lval = nums[l]*nums[l];
            int rval = nums[r]*nums[r];
            if (lval > rval) {
                answer[i] = lval;
                l++;
                i--;
                continue;
            }
            if (lval<rval) {
                answer[i] = rval;
                r--;
                i--;
                continue;
            }
            if (lval == rval) {
                //无所谓 让左走吧
                answer[i] = lval;
                l++;
                i--;
                continue;
            }
        }
        answer[i] = nums[l]*nums[r];
        return answer;
    }
}
