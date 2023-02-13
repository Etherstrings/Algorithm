package src;

/**
 * @author Etherstrings
 * @create 2021-12-21 23:53 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  WhichDayOfYear3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/21 - the current system date.  23:53 - the current system time.  2021 - the current year.  12 - the current month.  21 - the current day of the month.  23 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class WhichDayOfYear3 {
    public static void main(String[] args) {
        String date="2019-01-09";
        Test test=new Test();
        test.getDays(date);
        System.out.println(test.getDays(date));

    }



}
class Test{
    public int getDays(String date){

        //创建char型的数组 数组长度为10 一一对应 从0-3为year 从5-6为月份 从8-9为天
        char[] year1=new char[4];
        char[] month1=new char[2];
        char[] day1=new char[2];
        date.getChars(0,4,year1,0);
        date.getChars(5,7,month1,0);
        date.getChars(8,10,day1,0);
        //将字符串char[]转化为int[];
        int[] year2=new int[4];
        int[] month2=new int[2];
        int[] day2=new int[2];
        for(int i=0;i<year1.length;i++){
            year2[i]=year1[i]-'0';
        }
        int year=year2[0]*1000+year2[1]*100+year2[2]*10+year2[3];
        for(int i=0;i<month1.length;i++){
            month2[i]=month1[i]-'0';
        }
        int month=month2[0]*10+month2[1];
        for(int i=0;i<day1.length;i++){
            day2[i]=day1[i]-'0';
        }
        int day=day2[0]*10+day2[1];
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