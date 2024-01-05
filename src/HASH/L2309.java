package HASH;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-24
 */
public class L2309 {
    //给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
    //
    // 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
    //
    // 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：s = "lEeTcOdE"
    //输出："E"
    //解释：
    //字母 'E' 是唯一一个大写和小写形式都出现的字母。
    //
    // 示例 2：
    //
    //
    //输入：s = "arRAzFif"
    //输出："R"
    //解释：
    //字母 'R' 是大写和小写形式都出现的最好英文字母。
    //注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
    //
    //
    // 示例 3：
    //
    //
    //输入：s = "AbCdEfGhIjK"
    //输出：""
    //解释：
    //不存在大写和小写形式都出现的字母。
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= s.length <= 1000
    // s 由小写和大写英文字母组成
    //
    //
    // Related Topics 哈希表 字符串 枚举 👍 47 👎 0
    public String greatestLetter(String s) {
        int[][] map = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                map[Character.toLowerCase(c) - 'a'][0]++;
            } else {
                map[c - 'a'][1]++;
            }
        }
        for(int i=25;i>=0;i--){
            char c = (char)('a'+i);
            if(map[c-'a'][0]>0&&map[c-'a'][1]>0){
                return Character.toUpperCase(c)+"";
            }
        }
        return "";
    }
}
