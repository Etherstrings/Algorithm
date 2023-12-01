package HASH;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-30
 */
public class L1657 {
    //如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
    //
    //
    // 操作 1：交换任意两个 现有 字符。
    //
    //
    //
    // 例如，abcde -> aecdb
    //
    //
    // 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
    //
    // 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
    //
    //
    //
    //
    // 你可以根据需要对任意一个字符串多次使用这两种操作。
    //
    // 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：word1 = "abc", word2 = "bca"
    //输出：true
    //解释：2 次操作从 word1 获得 word2 。
    //执行操作 1："abc" -> "acb"
    //执行操作 1："acb" -> "bca"
    //
    //
    // 示例 2：
    //
    //
    //输入：word1 = "a", word2 = "aa"
    //输出：false
    //解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
    //
    // 示例 3：
    //
    //
    //输入：word1 = "cabbba", word2 = "abbccc"
    //输出：true
    //解释：3 次操作从 word1 获得 word2 。
    //执行操作 1："cabbba" -> "caabbb"
    //执行操作 2："caabbb" -> "baaccc"
    //执行操作 2："baaccc" -> "abbccc"
    //
    //
    // 示例 4：
    //
    //
    //输入：word1 = "cabbba", word2 = "aabbss"
    //输出：false
    //解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= word1.length, word2.length <= 10⁵
    // word1 和 word2 仅包含小写英文字母
    //
    //
    // Related Topics 哈希表 字符串 排序 👍 97 👎 0
    //> 2023/11/30 11:03:42
    //解答成功:
    //	执行耗时:9 ms,击败了97.20% 的Java用户
    //	内存消耗:43.7 MB,击败了14.28% 的Java用户
    public boolean closeStrings(String word1, String word2) {
        //观察用例，怎么才能够变换？
        //1.长度相等
        //2.两个字符串中必须出现相同种类的字符
        //3.可以出现的字符是不一样的，但是这两个字符的出现个数需要相同
        //  比如字符串1可以出现的个数组合为3321
        //  字符串2必须出现的个数组合也为3321
        //  因此排序可以解决
        if(word1.length() != word2.length()) return false;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for(char c : word1.toCharArray()){
            chars1[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            chars2[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if((chars1[i] == 0 && chars2[i] != 0) || (chars1[i] != 0 && chars2[i] == 0)){
                return false;
            }
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i = 0; i < 26; i++){
            if(chars1[i] != chars2[i]){
                return false;
            }
        }
        return true;
    }
}
