package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-02-08 21:38
 */
public class L1 {
    public int[] twoSum(int[] nums, int target) {
        int[] answer=new int[2];
        if(nums==null||nums.length==0){
            return answer;
        }

        Map<Integer,Integer> judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(judge.containsKey(temp)){
                answer[1]=i;
                answer[0]=judge.get(temp);
            }
            judge.put(nums[i],i);
        }
        return answer;
    }
}
