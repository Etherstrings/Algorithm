package StringExer;

/**
 * @author Etherstrings
 * @create 2022-08-08 21:33 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII58 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/8 - the current system date.  21:33 - the current system time.  2022 - the current year.  08 - the current month.  08 - the current day of the month.  21 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class SII58 {

    //剑指 Offer 58 - II. 左旋转字符串
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "abcdefg", k = 2
    //输出: "cdefgab"
    //示例 2：
    //
    //输入: s = "lrloseumgh", k = 6
    //输出: "umghlrlose"
    public String reverseLeftWords(String s, int n) {
        String left=s.substring(0,n);
        String right=s.substring(n,s.length());
        return  right+left;
    }
}
