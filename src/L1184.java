/**
 * @author Etherstrings
 * @create 2022-07-24 23:40 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1184 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/24 - the current system date.  23:40 - the current system time.  2022 - the current year.  07 - the current month.  24 - the current day of the month.  23 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1184 {
    //1184. 公交站间的距离
    //环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
    //
    //环线上的公交车都可以按顺时针和逆时针的方向行驶。
    //
    //返回乘客从出发点 start 到目的地 destination 之间的最短距离。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：distance = [1,2,3,4], start = 0, destination = 1
    //输出：1
    //解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
    //
    //
    //示例 2：
    //
    //
    //
    //输入：distance = [1,2,3,4], start = 0, destination = 2
    //输出：3
    //解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }

        //从起点到重点
        int length1=0;
        //从0到起点
        int length2=0;
        for(int i=start;i<destination;i++){
            length1+=distance[i];
        }

        for(int i=0;i<start;i++){
            length2+=distance[i];
        }

        for(int i=destination;i<distance.length;i++){
            length2+=distance[i];
        }

        return Math.min(length1,length2);
    }
}
