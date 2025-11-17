package SecondTime.Tanxin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-27 13:21 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L56 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/27 - the current system date.  13:21 - the current system time.  2022 - the current year.  08 - the current month.  27 - the current day of the month.  13 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        //最小左边界
        int left=intervals[0][0];
        //当前右边界
        int right=intervals[0][1];

        for(int i=1;i< intervals.length;i++){
            int[] temp=intervals[i];
            if(temp[0]>right){
                //这俩不重复
                res.add(new int[]{left,right});
                left=temp[0];
                right=temp[1];
            }else {
                //重叠了
                right=Math.max(right,temp[1]);
            }
        }
        res.add(new int[]{left,right});
        return res.toArray(new int[res.size()][]);
    }
}
