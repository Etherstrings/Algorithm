package JinZhi;

/**
 * @author Etherstrings
 * @create 2023-03-02 11:22 JinZhi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  LMian5_2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/2 - the current system date.  11:22 - the current system time.  2023 - the current year.  03 - the current month.  02 - the current day of the month.  11 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class LMian5_2 {
    //十进制小数转二进制小数的方法是：小数部分乘以 2，取整数部分作为二进制小数的下一位，小数部分作为下一次乘法的被乘数，直到小数部分为 00 或者二进制小数的长度超过 3232 位。
    public String printBin(double num) {
        StringBuilder sb=new StringBuilder("0.");
        while (sb.length()<32&&num!=0){
            num=num*2;
            int now=(int)num;
            num=num-now;
            sb.append(now);
        }
        return num != 0 ? "ERROR" : sb.toString();
    }
}
