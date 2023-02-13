package src;

import java.util.HashSet;
import java.util.Set;

public class L260 {
    //给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    //
    //
    //
    //进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,1,3,2,5]
    //输出：[3,5]
    //解释：[5, 3] 也是有效的答案。
    //示例 2：
    //
    //输入：nums = [-1,0]
    //输出：[-1,0]
    //示例 3：
    //
    //输入：nums = [0,1]
    //输出：[1,0]
    public int[] singleNumber(int[] nums) {
        Set<Integer> Judge=new HashSet<>();

        for(int a:nums){
            if(Judge.contains(a)){
                Judge.remove(a);
            }else {
                Judge.add(a);
            }
        }
        int i=0;
        int[] ans=new int[2];
        for(int a:Judge){
            ans[i]=a;
            i++;
        }
        return ans;
    }
}
