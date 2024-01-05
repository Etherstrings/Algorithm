package leetcode.week373;

public class num3 {
    //给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
    //
    //在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
    //
    //返回执行任意次操作后能得到的 字典序最小的数组 。
    //
    //如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应字符比数组 b 中的对应字符的字典序更小，则认为数组 a 就比数组 b 字典序更小。
    // 例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。

    public int[] lexicographicallySmallestArray(int[] nums, int limit){
        boolean gloabl = true;
        boolean[] flag = new boolean[nums.length];
        int changed = 0;
        //当前只能和后面的交换
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=limit){
                    if(nums[i]<=nums[j]){
                        continue;
                    }
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    flag[i]=true;
                }
            }
        }
        while(gloabl){
            if(changed==0){
                break;
            }
            boolean[] tempB = new boolean[nums.length];
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(Math.abs(nums[i]-nums[j])<=limit){
                        if(nums[i]<=nums[j]){
                            continue;
                        }
                        if(flag[i]){
                            int temp = nums[i];
                            nums[i]=nums[j];
                            nums[j]=temp;
                            tempB[i]=true;
                        }
                    }
                }
            }
        }



        return nums;
    }
}
