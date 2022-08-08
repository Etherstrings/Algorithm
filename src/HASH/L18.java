package HASH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-08 11:08
 */
public class L18 {
    //18. 四数之和
    //给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
    //
    //0 <= a, b, c, d < n
    //a、b、c 和 d 互不相同
    //nums[a] + nums[b] + nums[c] + nums[d] == target
    //你可以按 任意顺序 返回答案 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,0,-1,0,-2,2], target = 0
    //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    //示例 2：
    //
    //输入：nums = [2,2,2,2,2], target = 8
    //输出：[[2,2,2,2]]
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length<4||nums==null){
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //外层i
            if(nums[i]>0&&nums[i]>target){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            for(int j=i+1;i<nums.length;j++){
                //里层i
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;

                while(left<right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target){
                        Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        while ((left<right&&nums[left]==nums[left+1])){
                            left++;
                        }
                        left++;
                        right--;
                    }else if(sum>target){
                        left++;
                    }else {
                        right--;
                    }


                }

            }

        }
        return ans;
    }
}
