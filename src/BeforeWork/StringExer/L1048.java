package StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-04-28 15:32 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1048 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/28 - the current system date.  15:32 - the current system time.  2023 - the current year.  04 - the current month.  28 - the current day of the month.  15 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L1048 {
    //1048. 最长字符串链
    //给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
    //
    //如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
    //
    //例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
    //词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
    //
    //从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
    //
    //
    //示例 1：
    //
    //输入：words = ["a","b","ba","bca","bda","bdca"]
    //输出：4
    //解释：最长单词链之一为 ["a","ba","bda","bdca"]
    //示例 2:
    //
    //输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
    //输出：5
    //解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
    //示例 3:
    //
    //输入：words = ["abcd","dbqca"]
    //输出：1
    //解释：字链["abcd"]是最长的字链之一。
    //["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
    public int longestStrChain(String[] words) {
        //从后往前找
        List<String> list=new ArrayList<>();
        for(String word:words){
            list.add(word);
        }
        return 1;
    }
}
