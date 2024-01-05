package HASH;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-23
 */
public class L1876 {
    public static void main(String[] args) {
        String s = "xyzzaz";
        System.out.println(countGoodSubstrings(s));
    }
    public static int countGoodSubstrings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        HashSet<Character> set;
        for(int i=0;i<n-2;i++){
            set = new HashSet<Character>();
            set.add(chars[i]);
            set.add(chars[i+1]);
            set.add(chars[i+2]);
            if(set.size()==3){
                ans++;
            }
        }
        return ans;
    }

    public static boolean isGood(HashMap<Character,Integer> map){
        for(char chara:map.keySet()){
            if(map.get(chara)>1){
                return false;
            }
        }
        return true;
    }
}
