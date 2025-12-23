package WorkReview.CralBook.TwoArrow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-22
 */
public class L3NoRepeatLongstString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    //Set做
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s==null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0;i<s.length();i++) {
            //每一个循环从i开始
            int len = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j=i+1;j<s.length();j++) {
                if (set.contains(s.charAt(j))) {
                    ans = Math.max(j-i,ans);
                    break;
                }
            }
        }
        return ans;
    }
}
