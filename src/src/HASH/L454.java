package src.HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-02-10 19:07
 */
public class L454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        //思路
        //1 2 所有的和a-次数
        //3 4 如果出现有和可以满足 -b+a=0 次数加
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int a:nums1){
            for(int b:nums2){
                int temp=a+b;
                if(Judge.containsKey(temp)){
                    Judge.put(temp,Judge.get(temp)+1);
                }else {
                    Judge.put(temp,1);
                }
            }
        }
        int ans=0;
        for(int a:nums3){
            for(int b:nums4){
                int temp=a+b;
                if(Judge.containsKey(-temp)){
                    ans+=Judge.get(-temp);
                }
            }
        }
        return ans;
    }
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            int temp;
            int res = 0;
            //统计两个数组中的元素之和，同时统计出现的次数，放入map
            for (int i : nums1) {
                for (int j : nums2) {
                    temp = i + j;
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
            }
            //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
            for (int i : nums3) {
                for (int j : nums4) {
                    temp = i + j;
                    if (map.containsKey(0 - temp)) {
                        res += map.get(0 - temp);
                    }
                }
            }
            return res;
        }


}
