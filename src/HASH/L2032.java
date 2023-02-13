package HASH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        //1 2
        for(int num:nums1){
            set1.add(num);
            set2.add(num);
        }
        HashSet<Integer> OneTwo=new HashSet<>();
        for(int num:nums2){
            if(set1.contains(num)){
                OneTwo.add(num);
            }
            set2.add(num);
        }
        //2 3
        set1=new HashSet<>();
        for(int num:nums2){
            set1.add(num);
        }
        HashSet<Integer> TwoThree=new HashSet<>();
        for(int num:nums3){
            if(set1.contains(num)){
                TwoThree.add(num);
            }
            set2.add(num);
        }
        //1 3
        set1=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        HashSet<Integer> OneThree=new HashSet<>();
        for(int num:nums3){
            if(set1.contains(num)){
                OneThree.add(num);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int num:set2){
            if(OneTwo.contains(num)||OneThree.contains(num)||TwoThree.contains(num)){
                ans.add(num);
            }
        }
        return ans;
    }
}
