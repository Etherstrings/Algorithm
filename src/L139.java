import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-18 12:03 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L139 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/18 - the current system date.  12:03 - the current system time.  2022 - the current year.  06 - the current month.  18 - the current day of the month.  12 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L139 {
    //139. 单词拆分
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    //
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    //示例 2：
    //
    //输入: s = "applepenapple", wordDict = ["apple", "pen"]
    //输出: true
    //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    //     注意，你可以重复使用字典中的单词。
    //示例 3：
    //
    //输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    //输出: false
    //
    //
    //提示：
    //
    //1 <= s.length <= 300
    //1 <= wordDict.length <= 1000
    //1 <= wordDict[i].length <= 20
    //s 和 wordDict[i] 仅有小写英文字母组成
    //wordDict 中的所有字符串 互不相同

    public boolean wordBreak(String s, List<String> wordDict) {
        //将字典转换为数字
        List<String> IntDict=new ArrayList<>();
        for(String a:wordDict){
            IntDict.add(Transform(a));
        }
        //s转换为数字
        String transS = Transform(s);

        //对比
        return false;
    }




    //将字符串转换为数字编码
    String Transform(String s){
        String Str2int="";
        for(int i=0;i<s.length();i++){
            Str2int+=s.charAt(i)-'a';
        }
        return Str2int;
    }

}
