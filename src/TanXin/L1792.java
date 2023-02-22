package TanXin;

import java.util.PriorityQueue;

/**
 * @author Etherstrings
 * @create 2023-02-19 1:43 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1792 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/19 - the current system date.  1:43 - the current system time.  2023 - the current year.  02 - the current month.  19 - the current day of the month.  01 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //大顶堆
        //每次都取出来增长率最大的
        PriorityQueue<int[]> bigding = new PriorityQueue<int[]>((o1,o2) -> {
            double avg1 = (o1[0] + 0.0) / o1[1];
            double avg2 = (o2[0] + 0.0) / o2[1];

            double avg1_add = (o1[0] + 1.0) / (o1[1] + 1.0);
            double avg2_add = (o2[0] + 1.0) / (o2[1] + 1.0);

            double res = Double.compare(avg1_add - avg1, avg2_add - avg2);
            if (res > 0) {
                return -1;
            } else {
                return 1;
            }
        }
        );
        for(int[] clas:classes){
            bigding.offer(clas);
        }
        while(extraStudents>0){
            int[] poll = bigding.poll();
            poll[0]=poll[0]+1;
            poll[1]=poll[1]+1;
            bigding.offer(poll);
            extraStudents--;
        }
        double ans=0;
        while(!bigding.isEmpty()){
            int[] poll = bigding.poll();
            ans+=(double) poll[0]/poll[1];
        }
        return ans/classes.length;
    }
}
