package ShuLun;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2023-05-10 10:25 ShuLun - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1050 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/10 - the current system date.  10:25 - the current system time.  2023 - the current year.  05 - the current month.  10 - the current day of the month.  10 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1050 {
    //1015. 可被 K 整除的最小整数
    //给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
    //
    //返回 n 的长度。如果不存在这样的 n ，就返回-1。
    //
    //注意： n 不符合 64 位带符号整数。
    //
    //
    //
    //示例 1：
    //
    //输入：k = 1
    //输出：1
    //解释：最小的答案是 n = 1，其长度为 1。
    //示例 2：
    //
    //输入：k = 2
    //输出：-1
    //解释：不存在可被 2 整除的正整数 n 。
    //示例 3：
    //
    //输入：k = 3
    //输出：3
    //解释：最小的答案是 n = 111，其长度为 3。
    public int smallestRepunitDivByK(int k) {
        if(k%5==0||k%2==0){
            return -1;
        }
        Set<Integer> seen=new HashSet<>();
        int x = 1 % k;
        while (x > 0 && seen.add(x))
            x = (x * 10 + 1) % k;
        return x > 0 ? -1 : seen.size() + 1;
    }
}
