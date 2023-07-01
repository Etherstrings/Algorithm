package leetcode.week351;

import java.util.ArrayList;
import java.util.List;

public class num3 {
    //6910. 将数组划分成若干好子数组的方式 显示英文描述
    //通过的用户数897
    //尝试过的用户数1096
    //用户总通过次数909
    //用户总提交次数2356
    //题目难度Medium
    //给你一个二元数组 nums 。
    //
    //如果数组中的某个子数组 恰好 只存在 一 个值为 1 的元素，则认为该子数组是一个 好子数组 。
    //
    //请你统计将数组 nums 划分成若干 好子数组 的方法数，并以整数形式返回。由于数字可能很大，返回其对 109 + 7 取余 之后的结果。
    //
    //子数组是数组中的一个连续 非空 元素序列。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [0,1,0,0,1]
    //输出：3
    //解释：存在 3 种可以将 nums 划分成若干好子数组的方式：
    //- [0,1] [0,0,1]
    //- [0,1,0] [0,1]
    //- [0,1,0,0] [1]
    //示例 2：
    //
    //输入：nums = [0,1,0]
    //输出：1
    //解释：存在 1 种可以将 nums 划分成若干好子数组的方式：
    //- [0,1,0]
    //
    //
    //提示：
    //
    //1 <= nums.length <= 105
    //0 <= nums[i] <= 1


    //1个 那就不能拆
    //2个 那就有一个拆分点
    //3个 那就有2个拆分点
    public int numberOfGoodSubarraySplits(int[] nums) {
        final int MOD = 1000000007;
        int k=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) {
                k++;
                list.add(i);
            }
        }
        if(k==0){
            return 0;
        }
        if(k==1){
            return 1;
        }
        long ans=1;
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){
                continue;
            }
            int now=list.get(i);
            int next=list.get(i+1);
            ans=(ans*(now-next))%MOD;
        }
        return Math.abs((int)ans);
    }


}
