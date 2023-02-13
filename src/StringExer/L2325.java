package StringExer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Justice_wby
 * @create 2023-02-01 10:22
 */
public class L2325 {

    public static String decodeMessage(String key, String message) {
        Set<Character> set=new HashSet<>();
        char[] showup=new char[26];
        int i=0;
        for(Character n:key.toCharArray()){
            if(n==' '){
                continue;
            }
            char now=Character.toLowerCase(n);
            if(set.contains(now)){
                continue;
            }else {
                set.add(now);
                showup[i]=now;
                i++;
            }
        }
        HashMap<Character,Character> map=new HashMap<>();
        for(i=0;i<showup.length;i++){
            map.put(showup[i], (char) (97+i));
        }
        StringBuffer ans=new StringBuffer("");
        for(char now:message.toCharArray()){
            if(now==' '){
                ans.append(now);
                continue;
            }
            ans.append(map.get(now));
        }
        return ans.toString();
    }
}
