package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-17 11:01 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Lsword58 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/17 - the current system date.  11:01 - the current system time.  2022 - the current year.  02 - the current month.  17 - the current day of the month.  11 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class Lsword58 {
    //剑指 Offer 58 - II. 左旋转字符串
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    //

    public String reverseLeftWords(String s, int n) {
        //思路
        //先切分
        //再拼接
        String left=s.substring(0,n);
        String right=s.substring(n);
        return right+left;
    }
}
