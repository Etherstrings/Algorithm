package src.BackStracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L532 {
    //532. 数组中的 k-diff 数对
    //难度
    //中等
    //
    //234
    //
    //
    //
    //
    //
    //给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
    //
    //k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
    //
    //0 <= i, j < nums.length
    //i != j
    //nums[i] - nums[j] == k
    //注意，|val| 表示 val 的绝对值。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [3, 1, 4, 1, 5], k = 2
    //输出：2
    //解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
    //尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
    //示例 2：
    //
    //输入：nums = [1, 2, 3, 4, 5], k = 1
    //输出：4
    //解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
    //示例 3：
    //
    //输入：nums = [1, 3, 1, 5, 4], k = 0
    //输出：1
    //解释：数组中只有一个 0-diff 数对，(1, 1) 。
    //
    //
    //提示：
    //
    //1 <= nums.length <= 104
    //-107 <= nums[i] <= 107
    //0 <= k <= 107


    public int findPairs(int[] nums, int k) {
        if(nums.length==1){
            return 0;
        }
        //直接双指针吧？
        Arrays.sort(nums);
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>=1){
                if(nums[i]==nums[i-1]){
                    continue;
                }else {
                    for(int j=i+1;j<nums.length;j++){
                        if(nums[j]-nums[i]==k){
                            if(Judge.containsKey(nums[k])){
                                continue;
                            }else {
                                Judge.put(nums[k],1);
                            }
                        }
                    }
                }
            }
        }
        return Judge.size();
    }

    //考虑回溯
    //挨个取数目

    //参数传什么？

    //这次是谁的？
        //0 1 2 3 ... n

    void BackTarcking(int index,int[] nums){

        //终止条件
            //找到末尾了
            if(index==nums.length-1){
                return;
            }
    }


    public int findPairs1(int[] nums, int k) {
        Set<Integer> Seen=new HashSet<>();
        Set<Integer> Ans=new HashSet<>();
        for(int num:nums){
            if(Seen.contains(num-k)){
                Ans.add(num-k);
            }
            if(Seen.contains(k+num)){
                Ans.add(num);
            }
            Seen.add(num);
        }
        return Ans.size();
    }

}
