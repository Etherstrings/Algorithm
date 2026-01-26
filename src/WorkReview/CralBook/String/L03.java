package WorkReview.CralBook.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L03 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s==null) {
            return 0;
        }
        int ans = 0;
        int slow = 0;
        int fast = 0;
        Set<Character> set = new HashSet<>();
        while (fast<s.length()) {
            while (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            }
            set.add(s.charAt(fast));
            ans = Math.max(ans,fast-slow+1);
            fast++;
        }
        return ans;
    }
}
