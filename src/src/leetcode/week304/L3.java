package src.leetcode.week304;

/**
 * @author Etherstrings
 * @create 2022-07-31 11:28 leetcode.week304 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  11:28 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  11 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L3 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //用一个数组判断node1是不是到了这
        boolean[] used=new boolean[edges.length];
        used[node1]=true;
        //下一个节点
        int next=edges[node1];
        int times=0;
        while(next!=-1||times==edges.length){
            used[next]=true;
            next=edges[next];
            if(next==-1){
                used[next]=true;
            }
            times++;
        }
        int N2next=edges[node2];
        int length=0;
        while(used[N2next]!=true){
            length++;
            N2next=edges[N2next];
            if(used[N2next]==true){
                length++;
            }
        }
        return length;
    }
}
