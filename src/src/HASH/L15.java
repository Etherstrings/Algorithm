package src.HASH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-08 10:30
 */
public class L15 {
    //15. 三数之和
    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]
    //示例 2：
    //
    //输入：nums = []
    //输出：[]
    //示例 3：
    //
    //输入：nums = [0]
    //输出：[]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //排序 这样才可以相加为0
        Arrays.sort(nums);

        //i 自增 从0开始
        //L L=i+1
        //R R=len-1
        for (int i = 0; i < nums.length; i++) {
            //如果当前的i大于0
            //L R >0 不可能==0
            if (nums[i] > 0) {
                return result;
            }

            //如果当前i>0 而且现在的i和上一个i相同
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;


            while (right > left) {


                int sum = nums[i] + nums[left] + nums[right];


                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}
