package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-11
 */
public class L630 {
    public static void main(String[] args) {

    }
    public static int scheduleCourse(int[][] courses) {
        //课程表规划安排
        //courses 0代表持续时间 1代表结束时间
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        };
        Arrays.sort(courses,com);
        Queue<Integer> bigque = new PriorityQueue<>((x, y) -> (y - x));
        int nowtime=0;
        for(int[] course:courses){
            int dur=course[0];
            int endtime=course[1];
            bigque.offer(dur);
            nowtime+=dur;
            while(nowtime>endtime){
                nowtime-=bigque.poll();
            }
        }
        return bigque.size();
    }
}
