package leetcode.week306;

import java.nio.charset.StandardCharsets;

/**
 * @author Etherstrings
 * @create 2022-08-14 11:12 leetcode.week306 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L150 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  11:12 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  11 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L150 {
    //6150. 根据模式串构造最小数字 显示英文描述
    //通过的用户数1107
    //尝试过的用户数1264
    //用户总通过次数1118
    //用户总提交次数1501
    //题目难度Medium
    //给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
    //
    //你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
    //
    //num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
    //如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
    //如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
    //请你返回满足上述条件字典序 最小 的字符串 num。
    //
    //
    //
    //示例 1：
    //
    //输入：pattern = "IIIDIDDD"
    //输出："123549876"
    //解释：
    //下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
    //下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
    //一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
    //"123549876" 是满足条件最小的数字。
    //注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
    //示例 2：
    //
    //输入：pattern = "DDD"
    //输出："4321"
    //解释：
    //一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
    //"4321" 是满足条件最小的数字。

    public String smallestNumber(String pattern) {
        //回溯或者动态规划
        boolean[] panduan=new boolean[9];

    }

    String BackTarcking()
}
