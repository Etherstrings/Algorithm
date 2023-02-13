package src;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-04 14:24
 */
public class L283 {
    //283. 移动零
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    //请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //示例 2:
    //
    //输入: nums = [0]
    //输出: [0]
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        // 后面的元素全变成 0
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
