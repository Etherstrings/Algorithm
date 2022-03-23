import sun.text.normalizer.RangeValueIterator;

/**
 * @author Etherstrings
 * @create 2022-02-19 12:03 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L9isPalindrome - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/19 - the current system date.  12:03 - the current system time.  2022 - the current year.  02 - the current month.  19 - the current day of the month.  12 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L9isPalindrome {
    //9. 回文数
    //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //例如，121 是回文，而 123 不是。
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){
            return false;
        }



        int reversed=0;

        while(x>reversed){
            reversed=reversed*10+x%10;
            x/=10;
        }

        return x==reversed||x==reversed/10;

    }
}
