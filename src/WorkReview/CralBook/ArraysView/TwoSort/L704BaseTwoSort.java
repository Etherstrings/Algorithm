package WorkReview.CralBook.ArraysView.TwoSort;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-10-22
 */
public class L704BaseTwoSort {
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果 target 存在返
    //回下标，否则返回 -1。
    //
    // 你必须编写一个具有 O(log n) 时间复杂度的算法。
    //
    // 示例 1:
    //
    //
    //输入: nums = [-1,0,3,5,9,12], target = 9
    //输出: 4
    //解释: 9 出现在 nums 中并且下标为 4
    //
    //
    // 示例 2:
    //
    //
    //输入: nums = [-1,0,3,5,9,12], target = 2
    //输出: -1
    //解释: 2 不存在 nums 中因此返回 -1
    //
    //
    //
    //
    // 提示：
    //
    //
    // 你可以假设 nums 中的所有元素是不重复的。
    // n 将在 [1, 10000]之间。
    // nums 的每个元素都将在 [-9999, 9999]之间。
    //
    //
    // Related Topics 数组 二分查找 👍 1805 👎 0
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int answer = getAnswer(nums, target);
        System.out.println(answer);
    }
    //输入: nums = [-1,0,3,5,9,12], target = 2
    //输出: -1

    //左右闭 小于等于 索引加减1
    public static int twoCutSearch(int[] nums, int target) {
        int leftI = 0;
        int rightI = nums.length - 1;
        while (leftI <= rightI) {
            int midI = leftI + (rightI-leftI)/2;
            int midV = nums[midI];
            if (midV < target) {
                leftI = midI + 1;
            } else if (midV > target) {
                rightI = midI - 1;
            } else {
                return midI;
            }
        }
        return -1;
    }



    public static int getAnswer(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }





}
