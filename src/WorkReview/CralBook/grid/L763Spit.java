package WorkReview.CralBook.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-20
 */
public class L763Spit {
    public List<Integer> partitionLabels(String s) {
        //维护当前拆分的字符串的出现的最后的长度
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i),i);
        }
        List<Integer> ans = new ArrayList<>();
        int maxRight = -1;
        int start = 0;
        for (int i=0;i<s.length();i++) {
            maxRight = Math.max(map.get(s.charAt(i)),maxRight);
            if (maxRight == i) {
                ans.add(i-start);
                start++;
            }
        }
        return ans;
    }
}
