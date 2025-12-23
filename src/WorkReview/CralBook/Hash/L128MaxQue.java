package WorkReview.CralBook.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-22
 */
public class L128MaxQue {
    //输入：nums = [1,0,1,2]
    //输出：3
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            int cur = 1;
            while (set.contains(num)) {
                num++;
                if (set.contains(num)) {
                    cur++;
                }
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
