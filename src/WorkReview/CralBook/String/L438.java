package WorkReview.CralBook.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        String key = getKey(p);
        for (int i=0;i<s.length()-p.length()+1;i++) {
            if (Objects.equals(getKey(s.substring(i,i+p.length())),key)) ans.add(i);
        }
        return ans;

    }

    public static String getKey(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
