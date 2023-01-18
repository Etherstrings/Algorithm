package HASH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Justice_wby
 * @create 2023-01-17 12:00
 */
public class L1814 {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        Set<Integer> keys=new HashSet<>();
        for(int num:nums){
            int temp=num-trans(num);
            keys.add(temp);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        for(int key:keys){
            int sum=map.get(key);
            if(sum>1){
                ans=(ans+getp(sum))% 1000000007;
            }

        }
        return (int)ans%MOD;
    }

    public static int trans(int num){
        int b=0;
        while (num != 0) {
            b = b * 10 + num % 10;
            num /= 10;
        }
        return b;
    }

    public static int getp(int num){
        int res=0;
        while(num>0){
            res = (res + --num) % 1000000007;
        }
        return res;
    }
}
