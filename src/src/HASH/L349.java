package src.HASH;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-02-07 22:39
 */
public class L349 {
    /**
     * 349. 两个数组的交集
     *
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
     * 输出结果中的每个元素一定是 唯一 的。
     * 我们可以 不考虑输出结果的顺序 。
     *
     *
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> judge=new HashSet<>();
        Set<Integer> answer=new HashSet<>();
        for(int i:nums1){
            judge.add(i);
        }

        for(int i:nums2){
            if(judge.contains(i)){
                answer.add(i);
            }
        }

        //answer就是最后的值
        int[] really=new int[answer.size()];
        int index=0;
        for(int i:answer){
            really[index++]=i;
        }

        return really;
    }

    public int[] intersection1(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        //先转换nums1
        //再遍历另一个数组---操作转换后的nums1
        //只需要返回哪个数共同出现 不需要返回出现次数
        Set<Integer> Judge=new HashSet<>();
        for(int a:nums1){
            Judge.add(a);
        }
        Set<Integer> Aans=new HashSet<>();
        for(int b:nums2){
            if(Judge.contains(b)){
                Aans.add(b);
            }
        }
        int[] ans=new int[Aans.size()];
        int i=0;
        for(int a:Aans){
            ans[i]=a;
            i++;
        }
        return ans;
    }
}
