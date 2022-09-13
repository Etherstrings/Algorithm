package SecondTime.Tanxin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Etherstrings
 * @create 2022-08-25 23:04 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L406 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/25 - the current system date.  23:04 - the current system time.  2022 - the current year.  08 - the current month.  25 - the current day of the month.  23 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L406 {
    public int[][] reconstructQueue(int[][] people) {
        //身高 前边有几个人
        //两个维度
        //先定下来一个维度

        //1.com 根据身高
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0]==o1[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        };
        Arrays.sort(people,com);
        LinkedList<int[]> que = new LinkedList<>();
        for(int[] a:people){
            que.add(a[1],a);
        }
        return que.toArray(new int[people.length][]);

    }
}
