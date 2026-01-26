package WorkReview.CralBook.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i=1;i<intervals.length;i++) {
            int nowleft = intervals[i][0];
            int nowright = intervals[i][1];
            if (nowleft<=right) {
                right = Math.max(nowright,right);
            } else {
                list.add(new int[]{left,right});
                left = nowleft;
                right = nowright;
            }
        }
        list.add(new int[]{left,right});
        int[][] ans = new int[list.size()][2];
        for (int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
