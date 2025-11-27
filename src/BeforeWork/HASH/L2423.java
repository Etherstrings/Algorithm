package HASH;

import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2023-04-29 12:07 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2423 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/29 - the current system date.  12:07 - the current system time.  2023 - the current year.  04 - the current month.  29 - the current day of the month.  12 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L2423 {
    //2423. 删除字符使频率相同
    //给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
    //
    //如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
    //
    //注意：
    //
    //字母 x 的 频率 是这个字母在字符串中出现的次数。
    //你 必须 恰好删除一个字母，不能一个字母都不删除。
    //
    //
    //示例 1：
    //
    //输入：word = "abcc"
    //输出：true
    //解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
    //示例 2：
    //
    //输入：word = "aazz"
    //输出：false
    //解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
    public static void main(String[] args) {
        System.out.println(equalFrequency("abbcc"));
    }
    public static boolean equalFrequency(String word) {
        int[] charCount = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            charCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            charCount[i]--;
            HashSet<Integer> frequency = new HashSet<Integer>();
            for (int f : charCount) {
                if (f > 0) {
                    frequency.add(f);
                }
            }
            if (frequency.size() == 1) {
                return true;
            }
            charCount[i]++;
        }
        return false;
    }

}
