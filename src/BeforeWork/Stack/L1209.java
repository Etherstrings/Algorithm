package Stack;

import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-13
 */
public class L1209 {

    ////给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
    ////
    //// 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
    ////
    //// 在执行完所有删除操作后，返回最终得到的字符串。
    ////
    //// 本题答案保证唯一。
    ////
    ////
    ////
    //// 示例 1：
    ////
    //// 输入：s = "abcd", k = 2
    ////输出："abcd"
    ////解释：没有要删除的内容。
    ////
    //// 示例 2：
    ////
    //// 输入：s = "deeedbbcccbdaa", k = 3
    ////输出："aa"
    ////解释：
    ////先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
    ////再删除 "bbb"，得到 "dddaa"
    ////最后删除 "ddd"，得到 "aa"
    ////
    //// 示例 3：
    ////
    //// 输入：s = "pbbcggttciiippooaais", k = 2
    ////输出："ps"
    ////
    ////
    ////
    ////
    //// 提示：
    ////
    ////
    //// 1 <= s.length <= 10^5
    //// 2 <= k <= 10^4
    //// s 中只含有小写英文字母。
    ////
    ////
    //// Related Topics 栈 字符串 👍 188 👎 0
    

    //> 2023/12/13 17:34:00
    //解答成功:
    //	执行耗时:66 ms,击败了26.06% 的Java用户
    //	内存消耗:43.2 MB,击败了72.97% 的Java用户

    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        //int[]
        //0: char
        //1: count
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int i = 0; i < cur[1]; i++) {
                sb.append((char) cur[0]);
            }
        }
        return sb.reverse().toString();
    }
}
