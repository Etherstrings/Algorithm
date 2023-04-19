package leetcode.week1;



import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-04-03 11:29 leetcode.week1 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6055_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/3 - the current system date.  11:29 - the current system time.  2022 - the current year.  04 - the current month.  03 - the current day of the month.  11 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L6055_1 {
    public static void main(String[] args) {
        L6055_1 a=new L6055_1();

        System.out.println(a.convertTime("04:30","06:30"));

    }


    //给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
    //
    //24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
    //
    //在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
    //
    //返回将 current 转化为 correct 需要的 最少操作数 。

    public int convertTime(String current, String correct) {
            if(current.equals(correct)){
                return 0;
            }
            char[] ccurrent = current.toCharArray();
            char[] ccorrect = correct.toCharArray();

            //11:00
            //小时
             String chour=String.valueOf(ccurrent[0])+String.valueOf(ccurrent[1]);
             String nhour=String.valueOf(ccorrect[0])+String.valueOf(ccorrect[1]);

             int intch=Integer.parseInt(chour);
             int intnh=Integer.parseInt(nhour);
            //分钟
            String cminute=String.valueOf(ccurrent[3])+String.valueOf(ccurrent[4]);
            String nminute=String.valueOf(ccorrect[3])+String.valueOf(ccorrect[4]);

            int intcm=Integer.parseInt(cminute);
            int intnm=Integer.parseInt(nminute);

            int nowAll=intch*60*60+intcm*60;
            int tagerAll=intnh*60*60+intnm*60;

            //计算差值
            //秒数
            int change=tagerAll-nowAll;

            //定义步数
            int sum=0;

            //总多少分钟
            int Allmin=change/60;


            //里面包含了多少小时？
            int hour=Allmin/60;
            //加上小时的操作数
            sum+=hour;
            //剩下的分钟
            Allmin-=hour*60;

            //里面包含了多少个15分钟
            int min15=Allmin/(15);
            sum+=min15;
            Allmin-=15*min15;

            //里面包含了多少个5分钟
            int min5=Allmin/(5);
            sum+=min5;
            Allmin-=5*min5;

            sum+=Allmin;

            return sum;







    }
}
