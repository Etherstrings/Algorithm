/**
 * @author Etherstrings
 * @create 2022-02-19 21:29 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L7 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/19 - the current system date.  21:29 - the current system time.  2022 - the current year.  02 - the current month.  19 - the current day of the month.  21 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L7 {
    //7. 整数反转
    //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    //
    //如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    //
    //假设环境不允许存储 64 位整数（有符号或无符号）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-integer
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int reverse(int x) {
        if(x==0){
            return x;
        }
        long rev=0;
        while(x!=0){
            rev=rev*10+x%10;
            x/=10;
        }
        return (int) rev==rev?(int)rev:0;


    }
}
