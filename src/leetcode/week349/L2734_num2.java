package leetcode.week349;

public class L2734_num2 {
    //2734. 执行子串操作后的字典序最小字符串 显示英文描述
    //通过的用户数2630
    //尝试过的用户数2981
    //用户总通过次数2672
    //用户总提交次数9667
    //题目难度Medium
    //给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
    //
    //选则 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
    //返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
    //
    //子字符串 是字符串中的一个连续字符序列。
    //
    //现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
    //
    //
    //示例 1：
    //
    //输入：s = "cbabc"
    //输出："baabc"
    //解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。
    //可以证明最终得到的字符串是字典序最小的。
    //示例 2：
    //
    //输入：s = "acbbc"
    //输出："abaab"
    //解释：我们选择从下标 1 开始、到下标 4 结束的子字符串执行操作。
    //可以证明最终得到的字符串是字典序最小的。
    //示例 3：
    //
    //输入：s = "leetcode"
    //输出："kddsbncd"
    //解释：我们选择整个字符串执行操作。
    //可以证明最终得到的字符串是字典序最小的。
    //
    //
    //提示：
    //
    //1 <= s.length <= 3 * 105
    //s 仅由小写英文字母组成
    public static String smallestString(String s) {
        //思路
        //前提：选择的所有的字串，都是要变化的，这个变化是一定的
        //因此，不能选择全部的a
        //找到第一个不是a的 将所有不是a的 变为前一位
        //在找到后的第一个a停止
        //如果全是a，最后一个变z
        char[] chars = s.toCharArray();
        int n=chars.length;
        for(int i=0;i<n;i++){
            if(chars[i]>'a'){
                //开始
                for(int j=i;j<n&&chars[j]!='a';j++){
                    chars[j]--;
                }
                return new String(chars);
            }
        }

        return new String(chars);
    }
}
