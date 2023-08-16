package BigFactoryProblems.MeiTuan_8_12;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-08-13 18:07 BigFactoryProblems.MeiTuan_8_12 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/13 - the current system date.  18:07 - the current system time.  2023 - the current year.  08 - the current month.  13 - the current day of the month.  18 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    //第一题：小美玩排列
    //
    //有一个排列，一共有n个数，还有特殊的两个数x和y，请你帮助小美判断x和y在排列中是否相邻，是则输出”Yes”，不是则输出”No”
    //
    //数据范围：
    //
    //1 ≤ n ≤ 1e5
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int x=Integer.parseInt(line1[0]);
        int y=Integer.parseInt(line1[1]);
        String[] line2=in.nextLine().split(" ");
        int[] nums=new int[line2.length];
        for(int i=0;i< line2.length;i++){
            nums[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(showup(x,y,nums));
    }

    public static boolean showup(int x,int y,int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int now=nums[i];
            int next=nums[i+1];
            if(now==x&&next==y||now==y&&next==x){
                return true;
            }
        }
        return false;
    }
}
