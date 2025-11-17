package StringExer;

import java.util.HashSet;
import java.util.Set;

public class L2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set=new HashSet<>();
        char ans=' ';
        for(char now:s.toCharArray()){
            if(set.contains(now)){
                ans=now;
                break;
            }else {
                set.add(now);
            }
        }
        return ans;
    }
}
