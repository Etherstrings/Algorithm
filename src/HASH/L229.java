package HASH;

import java.util.*;

public class L229 {
    //给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [3,2,3]
    //输出：[3]
    //示例 2：
    //
    //输入：nums = [1]
    //输出：[1]
    //示例 3：
    //
    //输入：nums = [1,2]
    //输出：[1,2]
    public List<Integer> majorityElement(int[] nums) {
        double Length=(nums.length)/3;
        HashMap<Integer,Integer> Judge=new HashMap<>();
        Set<Integer> Judge1=new HashSet<>();
        List<Integer> Answer=new ArrayList<>();
        for(Integer a:nums){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }

            Judge1.add(a);
        }
        for(Integer a:Judge1){
            if(Judge.get(a)>Length){
                Answer.add(a);
            }
        }
        return Answer;

    }
}
