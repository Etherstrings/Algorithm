package TanXin;

import java.util.*;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-21 16:58
 */
public class L56 {
    //56. 合并区间
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    //
    //
    //
    //示例 1：
    //
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2：
    //
    //输入：intervals = [[1,4],[4,5]]
    //输出：[[1,5]]
    //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
    //
    //
    //提示：
    //
    //1 <= intervals.length <= 104
    //intervals[i].length == 2
    //0 <= starti <= endi <= 104
    public int[][] merge(int[][] intervals) {
        //思路
        //首先 按 左排序
        //如果此区间的左>上一个的right 不合
        //如果当前区间的左<=上一个的right 合并
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(intervals,com);
        LinkedList<int[]> answer=new LinkedList<>();
        answer.add(intervals[0]);
        int lastright=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=lastright){
                //合并
                //当前区间的左区间 在上一个区间的右区间中
                int[] temp=answer.getLast();
                answer.removeLast();
                temp[1]=Math.max(intervals[i][1],lastright);
                answer.add(temp);
                lastright=Math.max(intervals[i][1],lastright);
            }else {
                //不合并
                answer.add(intervals[i]);
                lastright=intervals[i][1];
            }
        }
        return answer.toArray(new int[answer.size()][]);

    }
}
