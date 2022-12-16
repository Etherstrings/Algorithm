package src.Mianshi.Dajiang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-10 20:30 Mianshi.Dajiang - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L539 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/10 - the current system date.  20:30 - the current system time.  2022 - the current year.  08 - the current month.  10 - the current day of the month.  20 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L539 {
    //539. 最小时间差
    //给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
    //
    //
    //
    //示例 1：
    //
    //输入：timePoints = ["23:59","00:00"]
    //输出：1
    //示例 2：
    //
    //输入：timePoints = ["00:00","23:59","00:00"]
    //输出：0
    public int findMinDifference(List<String> timePoints) {
        //将String时间转换为分钟
        List<Integer> Temp=new ArrayList<>();
        for(String a:timePoints){
            Temp.add(Trans(a));
        }
        Collections.sort(Temp);
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<Temp.size();i++){
            int temp=Temp.get(i)-Temp.get(i-1);
            diff=Math.min(temp,diff);
        }
        return Math.min(diff,Temp.get(0)+1440-Temp.get(Temp.size()-1));
    }

    int Trans(String temp){

        int Hours=Integer.parseInt(temp.substring(0,1))*10*60+Integer.parseInt(temp.substring(1,2))*60;
        int Minutes=Integer.parseInt(temp.substring(3,4))*10+Integer.parseInt(temp.substring(4,5));
        return Hours+Minutes;
    }
}
