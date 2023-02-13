package src.BackStracking;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-26 14:05
 */
public class L698 {
    //698. 划分为k个相等的子集
    //给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
    //
    //
    //
    //示例 1：
    //
    //输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
    //输出： True
    //说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
    //示例 2:
    //
    //输入: nums = [1,2,3,4], k = 3
    //输出: false
    //
    //
    //提示：
    //
    //1 <= k <= len(nums) <= 16
    //0 < nums[i] < 10000
    //每个元素的频率在 [1,4] 范围内
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        boolean[] used=new boolean[nums.length];
        for(int a:nums){
            sum+=a;
        }
        if(sum%k!=0){
            return false;
        }
        int target=sum/k;
        int[] brcket=new int[k];
         return backtarcking(nums,brcket,used,k,target,0);
    }

    public boolean backtarcking(int[] nums,int[] brcket,boolean[] used,int k,int target,int start){
        //现在我是桶

        //第k个桶都装满了
        if(k==0){
            return true;
        }

        if(brcket[k-1]==target){
            //当前桶满了---到下一个桶
            return backtarcking(nums,brcket,used,k-1,target,0);
        }

        //当前桶
        //每个桶都从头到尾取一遍球
        for(int i=start;i<nums.length;i++){

            //这个球是不是被之前桶用过了？
            if(used[i]){
                continue;
            }
            if(brcket[k-1]>target){
                continue;
            }
            //标记使用
            //标记入桶
            used[i]=true;
            brcket[k-1]+=nums[i];
            //判断下个球 就是一条道走到黑
            if(backtarcking(nums,brcket,used,k,target,start+1)){
                return true;
            }
            used[i]=false;
            brcket[k-1]-=nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }

        }
        return false;
    }
}
