import LinkedList.J52;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findshowbest {
    public static String findbest(String str){
        HashMap<Character,Integer> judge=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(char a:str.toCharArray()){
            if(judge.containsKey(a)){
                judge.put(a,judge.get(a)+1);
            }else {
                judge.put(a,1);
            }
            set.add(a);
        }
        int value=-1;
        for(Character key:set){
            value=Math.max(judge.get(key),value);
        }
        String ans="";
        for(Character key:set){
            if(judge.get(key)==value){
                ans+=key;
                break;
            }
        }
        return ans;
    }
}
