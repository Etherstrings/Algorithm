import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-05-05 14:57 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2432 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/5 - the current system date.  14:57 - the current system time.  2023 - the current year.  05 - the current month.  05 - the current day of the month.  14 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2432 {
    //2432. 处理用时最长的那个任务的员工
    //共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。
    //
    //给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ：
    //
    //idi 是处理第 i 个任务的员工的 id ，且
    //leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。
    //注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。
    //
    //返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。
    //
    //
    public int hardestWorker(int n, int[][] logs) {
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        };
        Arrays.sort(logs,com);
        //按照任务结束时间排序
        //time-id(id更新为最小的)
        //维护一个时间最小值
        int len=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<logs.length;i++){
            int id=logs[i][0];
            int end=logs[i][1];
            if(i==0){
                map.put(end-0,id);
                len=Math.max(end-0,len);
                continue;
            }
            int time=end-logs[i-1][1];
            len=Math.max(time,len);
            if(map.containsKey(time)){
                //选择更小的id
                map.put(time,Math.min(id,map.get(time)));
            }else {
                map.put(time,id);
            }
        }
        return map.get(len);
    }
}
