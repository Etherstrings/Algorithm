package src;

/**
 * @author Etherstrings
 * @create 2022-01-03 15:17 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1185WhichDayOfAWeek - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/3 - the current system date.  15:17 - the current system time.  2022 - the current year.  01 - the current month.  03 - the current day of the month.  15 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L1185WhichDayOfAWeek {

    //给出的日期一定是在 1971 到 2100 年之间的有效日期。

    //先判断之前年份贡献了多少天
    //再判断当年年份 之前的月份 贡献了多少天
    //再判断现在月份 之前的日子 贡献了多少天

    public String dayOfTheWeek(int day, int month, int year) {
        String[] WeekDay={ "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        int[] monthsday={31,28,31,30,31,30,31,31,30,31,30,31};
        int days=0;
        //年份贡献的日子数
        days=(year-1971)*365+(year-1969)/4;
        //月份贡献的天数
        for(int i=0;i<month-1;++i){
            days+=monthsday[i];
        }
        if(((year%400==0)||(year%4==0&&year%100!=0))&&(month>=3)){
            days+=1;
        }
        //月份贡献的日子
        days+=day;
        return WeekDay[(days+3)%7];
    }
}
