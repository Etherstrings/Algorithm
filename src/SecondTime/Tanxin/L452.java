package SecondTime.Tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-08-25 23:14 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L452 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/25 - the current system date.  23:14 - the current system time.  2022 - the current year.  08 - the current month.  25 - the current day of the month.  23 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L452 {

    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        //现根据左边界排序
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(points,com);

        //现在左边是相同的

        //应该维护一个变量控制最小右边界
        int result=1;
        int right=points[0][1];

        //从1开始判断
        //如果左边界已经大于当前的最小有边界
        for(int i=1;i<points.length;i++){
            if(points[i][0]>right){
                result++;
                right=points[i][1];
            }else {
                right=Math.min(points[i][1],right);
            }
        }
        return result;
    }
}
