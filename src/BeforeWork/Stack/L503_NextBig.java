package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-03 11:47
 */
public class L503_NextBig {
    //503. 下一个更大元素 II
    //给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
    //
    //数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,2,1]
    //输出: [2,-1,2]
    //解释: 第一个 1 的下一个更大的数是 2；
    //数字 2 找不到下一个更大的数；
    //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    //示例 2:
    //
    //输入: nums = [1,2,3,4,3]
    //输出: [2,3,4,-1,4]
    public int[] nextGreaterElements1(int[] nums) {
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Judge.put(nums[i],i);
        }
        //Stack里存的是索引
        Stack<Integer> test=new Stack<>();
        int[] ans=new int[nums.length];
        Arrays.fill(ans,-1);
        //找到了当前数的开始位置
        for(int a:nums){
            int index=Judge.get(a);
            if(index==nums.length-1){
                //当前如果为最后一个的话
                for(int i=0;i<nums.length;i++){
                    if(nums[i]>a){
                        ans[index]=nums[i];
                    }
                }
            }
            if(index==0){
                for(int i=0;i<nums.length;i++){
                    if(nums[i]>a){
                        ans[index]=nums[i];
                    }
                }
            }
            //在中间
            for(int i=index;i<nums.length;i++){
                if(nums[i]>a){
                    ans[index]=nums[i];
                    break;
                }
            }
            if(ans[index]!=a){

            }else {
                for(int i=0;i<index;i++){
                    if(nums[i]>a){
                        ans[index]=nums[i];
                    }
                }
            }

        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums){
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int[] result=new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> Judge=new Stack<>();
        for(int i=0;i<2*nums.length;i++){
            while(!Judge.isEmpty()&&nums[i%nums.length]>nums[Judge.peek()]){
                result[Judge.peek()]=nums[i%nums.length];
                Judge.pop();
            }
            Judge.push(i%nums.length);
        }
        return result;
    }
}
