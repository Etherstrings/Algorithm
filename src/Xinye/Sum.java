package Xinye;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-09-22 19:18 Xinye - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Sum - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  19:18 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  19 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Sum {
    public int dateArraysSum (String[] dates) {
        // write code here
        int size=0;
        HashMap<String,Integer> Mon_Int=new HashMap<>();
        Mon_Int.put("Jan",1);
        Mon_Int.put("Feb",2);
        Mon_Int.put("Mar",3);
        Mon_Int.put("Apr",4);
        Mon_Int.put("May",5);
        Mon_Int.put("Jun",6);
        Mon_Int.put("Jul",7);
        Mon_Int.put("Aug",8);
        Mon_Int.put("Sep",9);
        Mon_Int.put("Oct",10);
        Mon_Int.put("Nov",11);
        Mon_Int.put("Dec",12);
        //过滤
        Set<String> Judge=new HashSet<>();
        for(String a:dates){
            Judge.add(a);
        }
        for(String a:Judge){
            String[] date=a.split(" ");
            int day=0;
            if(date[0].length()==3){
                day=Integer.parseInt(date[0].substring(0,1));
            }else {
                day=Integer.parseInt(date[0].substring(0,2));
            }
            int month=Mon_Int.get(date[1]);
            int year=Integer.parseInt(date[2]);
            size+=getDays(day,month,year);
        }
        return size;

    }


    public static int getDays(int day,int month,int year){
        int days=0;
        if(year%400==0){
            //闰年
            switch(month){
                case 12:
                    days+=30;
                case 11:
                    days+=31;
                case 10:
                    days+=30;
                case 9:
                    days+=31;
                case 8:
                    days+=31;
                case 7:
                    days+=30;
                case 6:
                    days+=31;
                case 5:
                    days+=30;
                case 4:
                    days+=31;
                case 3:
                    days+=29;
                case 2:
                    days+=31;
                case 1:
                    days+=day;
            }
            return days;
        }else{
            if(year%4==0){
                //闰年
                switch(month){
                    case 12:
                        days+=30;
                    case 11:
                        days+=31;
                    case 10:
                        days+=30;
                    case 9:
                        days+=31;
                    case 8:
                        days+=31;
                    case 7:
                        days+=30;
                    case 6:
                        days+=31;
                    case 5:
                        days+=30;
                    case 4:
                        days+=31;
                    case 3:
                        days+=29;
                    case 2:
                        days+=31;
                    case 1:
                        days+=day;
                }
                return days;
            }else{
                //不是闰年

                switch(month){
                    case 12:
                        days+=30;
                    case 11:
                        days+=31;
                    case 10:
                        days+=30;
                    case 9:
                        days+=31;
                    case 8:
                        days+=31;
                    case 7:
                        days+=30;
                    case 6:
                        days+=31;
                    case 5:
                        days+=30;
                    case 4:
                        days+=31;
                    case 3:
                        days+=28;
                    case 2:
                        days+=31;
                    case 1:
                        days+=day;
                }
                return days;
            }
        }
    }
}
