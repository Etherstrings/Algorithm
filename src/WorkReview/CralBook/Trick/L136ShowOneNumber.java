package WorkReview.CralBook.Trick;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-11
 */
public class L136ShowOneNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n:nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        for (int ans:set) {
            return ans;
        }
        return 0;
    }
}

