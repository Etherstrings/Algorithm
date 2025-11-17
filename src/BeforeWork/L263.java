/**
 * @author Etherstrings
 * @create 2022-06-19 15:38 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L263 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  15:38 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  15 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L263 {
    //263. 丑数
    //丑数 就是只包含质因数 2、3 和 5 的正整数。
    //
    //给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
    public boolean isUgly(int n) {
        int num=n;
        if (num<1) return false;
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%2==0){
            num>>=1;
        }
        return num == 1;
    }
}
