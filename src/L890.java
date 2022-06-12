import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-12 13:39 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L890 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/12 - the current system date.  13:39 - the current system time.  2022 - the current year.  06 - the current month.  12 - the current day of the month.  13 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */


/**
 * 这题必看 思路很爽
 * 第一次提交有三个样例没过 是因为在出现新字母时候 没有加入到Arraylist中
 */
public class L890 {
    //890. 查找和替换模式
    //你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
    //
    //如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
    //
    //（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
    //
    //返回 words 中与给定模式匹配的单词列表。
    //
    //你可以按任何顺序返回答案。
    //
    //
    //
    //示例：
    //
    //输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    //输出：["mee","aqq"]
    //解释：
    //"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
    //"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
    //因为 a 和 b 映射到同一个字母。
    //
    //
    //提示：
    //
    //1 <= words.length <= 50
    //1 <= pattern.length = words[i].length <= 20

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        //思路
        //1.用什么来表示Pattern？
        //2.遍历Words 判断输出
        List<String> Answer=new ArrayList<>();

        for(String word:words){
            if(Slove(word).equals(Slove(pattern))){
                Answer.add(word);
            }
        }
        return Answer;
    }

    private ArrayList<Integer> Slove(String pattern){
        //模式串代表
        //26个字母 用是否相同来表示
        // a b b 1 2 2
        // a b c 1 2 3
        // b b a 1 1 2

        //新字母---这个字母对应的索引+1
        //每到一个新的--判断是不是和之前的字母相同
        //如果相同 该位置填之前对应字母的索引
        //如果不同 索引+1

        //分解
        int index=0;

        //分解后的类别答案
        ArrayList<Integer> judgepattern=new ArrayList<>();

        //key填character Integer第一次出现对应的位置
        HashMap<Character,Integer> judgeindex=new HashMap<>();


        for(int i=0;i<pattern.length();i++){
            if(judgeindex.containsKey(pattern.charAt(i))){
                    //里面已经有了这个字母
                    //那就放入 ArrayList中对应的位置
                    //这是第几个出现的新字符？
                    judgepattern.add(judgeindex.get(pattern.charAt(i)));
            }else {
                //如果当前没存
                //第一次出现
                //第一次出现是第几个新字符？
                judgeindex.put(pattern.charAt(i),judgeindex.size()+1);

                //填入到ArrayList中
                judgepattern.add(judgeindex.get(pattern.charAt(i)));
            }
        }
        return judgepattern;


    }

}
