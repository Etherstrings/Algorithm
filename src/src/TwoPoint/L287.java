package src.TwoPoint;

public class L287 {
    //给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
    //
    //假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
    //
    //你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
    //
    public int findDuplicate(int[] nums) {
        //双指针遍历咯
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    ans=nums[i];
                    break;
                }
            }
        }
        return ans;
    }

}
