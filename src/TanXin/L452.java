package TanXin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-07-20 22:25 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L452 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/20 - the current system date.  22:25 - the current system time.  2022 - the current year.  07 - the current month.  20 - the current day of the month.  22 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L452 {
    //452. 用最少数量的箭引爆气球
    //有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
    //
    //一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
    //
    //给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
    //
    //
    //示例 1：
    //
    //输入：points = [[10,16],[2,8],[1,6],[7,12]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //-在x = 6处射出箭，击破气球[2,8]和[1,6]。
    //-在x = 11处发射箭，击破气球[10,16]和[7,12]。
    //示例 2：
    //
    //输入：points = [[1,2],[3,4],[5,6],[7,8]]
    //输出：4
    //解释：每个气球需要射出一支箭，总共需要4支箭。
    //示例 3：
    //
    //输入：points = [[1,2],[2,3],[3,4],[4,5]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
    //- 在x = 4处射出箭，击破气球[3,4]和[4,5]。
    public int findMinArrowShots(int[][] points) {
        //气球是怎么射的？
        //针从上往下射或者从下往上射
        // 12 23 34 2个才可以射爆
        //核心思路就是----一针射爆尽可能多的气球 左边界尽可能重叠
        //排序气球---根据左边边界排序
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(points,com);
        int count=1;
        for(int i=1;i<points.length;i++){
            //遍历这些气球
            //如果当前气球的左边界大于上一个气球的右边界
            //那这两个就不重叠 要再射一次了
            if(points[i][0]>points[i-1][1]){
                count++;
            }else {
                //选择小的右边界 作为组边界
                //因为一旦超过这个小的 那么小的就没法射 大的还可以
                points[i][1]=Math.min(points[i][1],points[i - 1][1]);
            }
        }
        return count;
    }
}
