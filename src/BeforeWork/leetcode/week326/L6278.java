package leetcode.week326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L6278 {
    public int countDigits(int num) {
        List<Integer> list=new ArrayList<>();
        String nums=num+"";
        for(char c:nums.toCharArray()){
            list.add(Integer.parseInt(c+""));
        }
        int ans=0;
        for(Integer t:list){
            if(num%t==0){
                ans++;
            }
        }
        return ans;
    }
}
