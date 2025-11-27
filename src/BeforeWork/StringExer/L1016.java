package StringExer;

/**
 * @author Etherstrings
 * @create 2023-05-11 10:10 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L016 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/11 - the current system date.  10:10 - the current system time.  2023 - the current year.  05 - the current month.  11 - the current day of the month.  10 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1016 {
    //1016. 子串能表示从 1 到 N 数字的二进制串
    //给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
    //
    //子字符串 是字符串中连续的字符序列。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "0110", n = 3
    //输出：true
    //示例 2：
    //
    //输入：s = "0110", n = 4
    //输出：false
    //
    //
    //提示：
    //
    //1 <= s.length <= 1000
    //s[i] 不是 '0' 就是 '1'
    //1 <= n <= 109
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
