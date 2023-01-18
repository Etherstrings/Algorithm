package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Justice_wby
 * @create 2023-01-13 14:18
 */
public class L2287 {
    //Wrong 不能做这道题目
    public static int rearrangeCharacters(String s, String target) {
        int ans=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for(Character now:s.toCharArray()){
            if(map.containsKey(now)){
                map.put(now,map.get(now)+1);
            }else {
                map.put(now,1);
            }
        }
        for(Character now:target.toCharArray()){
            ans=Math.min(map.get(now),ans);
        }
        return ans;
    }
}
