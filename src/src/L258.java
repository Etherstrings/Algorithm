package src;

/**
 * @author Etherstrings
 * @create 2022-03-03 10:48 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L258 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/3 - the current system date.  10:48 - the current system time.  2022 - the current year.  03 - the current month.  03 - the current day of the month.  10 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L258 {
    //258. 各位相加
    //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
    //
    //
    //
    //示例 1:
    //
    //输入: num = 38
    //输出: 2
    //解释: 各位相加的过程为：
    //38 --> 3 + 8 --> 11
    //11 --> 1 + 1 --> 2
    //由于 2 是一位数，所以返回 2。
    //示例 1:
    //
    //输入: num = 0
    //输出: 0

    public int addDigits(int num) {

        if(num<10||num==0){
            return num;
        }
        boolean Flag=true;
        while(num>=10){
            int answer=0;
            while(num>0){
                answer=num%10+answer;
                num/=10;
            }
            num=answer;
        }
        return num;

    }
}
