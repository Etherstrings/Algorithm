import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-25 21:15 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L692 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/25 - the current system date.  21:15 - the current system time.  2022 - the current year.  06 - the current month.  25 - the current day of the month.  21 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L692 {
    //692. 前K个高频单词
    //给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
    //
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
    //
    //
    //
    //示例 1：
    //
    //输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    //输出: ["i", "love"]
    //解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    //    注意，按字母顺序 "i" 在 "love" 之前。
    //示例 2：
    //
    //输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    //输出: ["the", "is", "sunny", "day"]
    //解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    //    出现次数依次为 4, 3, 2 和 1 次。
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> Judge=new HashMap<>();
        for(String word:words){
            if(Judge.containsKey(word)){
                Judge.put(word,Judge.get(word)+1);
            }else {
                Judge.put(word,1);
            }
        }

        //一个容器 用来排序Value
        ArrayList<Integer> values =(ArrayList<Integer>) Judge.values();
        Collections.sort(values);
        Collections.reverse(values);
        List<String> Answer=new ArrayList<>();
        for(int i=0;i<k;i++){
            for(String a:Judge.keySet()){
                if(Judge.get(a)==values.get(i)){
                    Answer.add(a);
                }
            }
        }
        List<String> RelAnswer=new ArrayList<>();
        for(int i=0;i<k;i++){
            RelAnswer.add(Answer.get(i));
        }
        return RelAnswer;
    }
}
