package BigFactoryProblems.MeiTuan_8_12;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-08-13 18:10 BigFactoryProblems.MeiTuan_8_12 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/13 - the current system date.  18:10 - the current system time.  2023 - the current year.  08 - the current month.  13 - the current day of the month.  18 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //第二题：小美走公路
    //
    //现有一条环形公路，总共有n个站点，a[i]代表第i个站点与第i+1个站点之间的距离，特殊的，a[n]表示第n个站点与第一个站点之间的距离。小美的出发地为x，目的地为y，请你求出x到y的最短距离
    //
    //1 ≤ n ≤ 1e5
    //
    //1 ≤ a[i] ≤ 1e9
    //
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int x=Integer.parseInt(line1[0]);
        int y=Integer.parseInt(line1[1]);
        String[] line2=in.nextLine().split(" ");
        long[] nums=new long[line2.length+1];
        for(int i=1;i<line2.length+1;i++){
            nums[i]=Long.parseLong(line2[i-1]);
        }
        int start=Math.min(x,y);
        int end=Math.max(x,y);
        Long Pathmid=0l;
        for(int i=start;i<end;i++){
            Pathmid+=nums[i];
        }
        Long Pathleft=0l;
        for(int i=1;i<start;i++){
            Pathleft+=nums[i];
        }
        Long Pathright=0l;
        for(int i=end;i< line2.length+1;i++){
            Pathright+=nums[i];
        }

    }
}
