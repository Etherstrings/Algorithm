package TanXin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-26 16:38
 */
public class L57 {
    //57. 插入区间
    //给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
    //
    //在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    //
    //
    //
    //示例 1：
    //
    //输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
    //输出：[[1,5],[6,9]]
    //示例 2：
    //
    //输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //输出：[[1,2],[3,10],[12,16]]
    //解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp=new ArrayList<>();
        if(intervals==null){
            int[][] ans=new int[1][newInterval.length];
            ans[0]=newInterval;
            return ans;
        }
        int left=newInterval[0];
        int right=newInterval[1];
        int a=1;
        for(int[] now:intervals){
            int mincur=now[0];
            int maxcur=now[1];
            if(maxcur<left){
                temp.add(now);
                continue;
            }
            //是不是第一次大于
            if(maxcur>right){
                if(a==1){
                    int[] t={left,right};
                    temp.add(t);
                    a++;
                }
                temp.add(now);
                continue;
            }
            left=Math.min(left,mincur);
            right=Math.max(right,maxcur);
        }
        int[][] ans=new int[temp.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
}
