package src.SecondTime.Tanxin;

/**
 * @author Etherstrings
 * @create 2022-08-24 19:04 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L134 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  19:04 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  19 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //总共消耗多少？
        //cost全部加一起

        //核心是什么？
        //核心是计算每天剩余多少？
        //如果当前剩余的小于0
        //就下一个
        int allcost=0;
        for(int i=0;i<cost.length;i++){
            allcost+=cost[i];
        }
        int allgas=0;
        for(int a:gas){
            allgas+=a;
        }
        if(allgas<allcost){
            return -1;
        }
        int start=0;
        int nowleft=0;
        for(int i=0;i< gas.length;i++){
            nowleft+=gas[i]-cost[i];
            if(nowleft<0){
                start=i+1;
                nowleft=0;
            }
        }
        return start;
    }
}
