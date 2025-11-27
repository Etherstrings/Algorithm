/**
 * @author Etherstrings
 * @create 2022-06-09 15:17 TwoTo2 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L167 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/9 - the current system date.  15:17 - the current system time.  2022 - the current year.  06 - the current month.  09 - the current day of the month.  15 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L67 {
    //67. 二进制求和
    //给你两个二进制字符串，返回它们的和（用二进制表示）。
    //
    //输入为 非空 字符串且只包含数字 1 和 0。
    //
    //
    //
    //示例 1:
    //
    //输入: a = "11", b = "1"
    //输出: "100"
    //示例 2:
    //
    //输入: a = "1010", b = "1011"
    //输出: "10101"
    //
    //
    //提示：
    //
    //每个字符串仅由字符 '0' 或 '1' 组成。
    //1 <= a.length, b.length <= 10^4
    //字符串如果不是 "0" ，就都不含前导零。

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


}
