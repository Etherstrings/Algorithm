package src.TanXin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-21 09:25
 */
public class L435 {
    //无重叠区间
    //Category	Difficulty	Likes	Dislikes
    //algorithms	Medium (50.88%)	745	-
    //Tags
    //Companies
    //给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
    //
    //
    //
    //示例 1:
    //
    //输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
    //输出: 1
    //解释: 移除 [1,3] 后，剩下的区间没有重叠。
    //示例 2:
    //
    //输入: intervals = [ [1,2], [1,2], [1,2] ]
    //输出: 2
    //解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
    //示例 3:
    //
    //输入: intervals = [ [1,2], [2,3] ]
    //输出: 0
    //解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
    public int eraseOverlapIntervals(int[][] intervals) {
        //首先按照右区间 从小到大对二维数组排序
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[1],o2[1]);
            }
        };

        //按照右区间的大小----从小到大的进行排序
        Arrays.sort(intervals,com);

        //遍历排序后区间
        //记录不重复的区间有哪些
        int count=0;
        int right=Integer.MIN_VALUE;
        for(int[] size:intervals){
            if(right<=size[0]){
                //上一个的右边 小于当前的左边
                //那这两个不重复，把当前的右边 当做 上一个的右边
                right=size[1];
            }else {
                //如果上一个的右边 和现在的左边有交集
                //那就跳过当前的这个右边---准备删除
                //用下一个的左边和上一个的右边比较
                count++;
            }
        }
        return count;
    }
}
