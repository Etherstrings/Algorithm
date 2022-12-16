package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-08-21 12:40 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1455 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/21 - the current system date.  12:40 - the current system time.  2022 - the current year.  08 - the current month.  21 - the current day of the month.  12 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1455 {
    //1455. 检查单词是否为句中其他单词的前缀
    //给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
    //
    //如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
    //
    //字符串 s 的 前缀 是 s 的任何前导连续子字符串。
    //
    //
    //
    //示例 1：
    //
    //输入：sentence = "i love eating burger", searchWord = "burg"
    //输出：4
    //解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
    //示例 2：
    //
    //输入：sentence = "this problem is an easy problem", searchWord = "pro"
    //输出：2
    //解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
    //示例 3：
    //
    //输入：sentence = "i am tired", searchWord = "you"
    //输出：-1
    //解释："you" 不是句子中任何单词的前缀。
    public int isPrefixOfWord(String sentence, String searchWord) {
        //根据空格分割
        String[] Words = sentence.split(" ");
        int ans=-1;
        for(int i=0;i<Words.length;i++){
            if(Words[i].startsWith(searchWord)){
                ans=i+1;
                break;
            }
        }
        return ans;
    }

}
