package StringExer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L648 {
    //648. 单词替换
    //在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
    //
    //现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
    //
    //你需要输出替换之后的句子。
    //
    //
    //
    //示例 1：
    //
    //输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    //输出："the cat was rat by the bat"
    //示例 2：
    //
    //输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
    //输出："a a b c"
    public String replaceWords(List<String> dictionary, String sentence) {
        //先切分sentence----拆为单个单词
        String[] words = sentence.split(" ");
        //根据dictionary匹配咯
            //匹配到就替换
            //替换长度最短的
        Comparator<String> com=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
        String ans="";
        for(String word:words){
            List<String> Matched=new ArrayList<>();
            //每个放进去的单词
            for(String dict:dictionary){
                //挨个拿dict匹配
                String temp = word.substring(0, dict.length());
                if(temp.equals(dict)){
                    //匹配到了当前的dict
                    Matched.add(dict);
                }
            }
            //word替换为Matched中最短的
            if(Matched.size()==0){
                //没有匹配到---直接拼接
                ans+=word;
                ans+=" ";
            }else {
                Collections.sort(Matched,com);
                ans+=Matched.get(0);
                ans+=" ";
            }
        }
        return ans.substring(0,ans.length()-1);

    }
}
