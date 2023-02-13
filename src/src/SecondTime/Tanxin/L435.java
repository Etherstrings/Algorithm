package src.SecondTime.Tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2022-08-26 21:17 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L435 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/26 - the current system date.  21:17 - the current system time.  2022 - the current year.  08 - the current month.  26 - the current day of the month.  21 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //首先根据右端点排序
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
                //当前的左边比上一个的右边大 已经超过了当前区间
                right=size[1];
            }else {
                count++;
            }
        }
        return count;
    }
}
