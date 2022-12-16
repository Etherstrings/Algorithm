package src.StringExer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-07-07 19:09 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L648 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/7 - the current system date.  19:09 - the current system time.  2022 - the current year.  07 - the current month.  07 - the current day of the month.  19 - the current hour.  09 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
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
        Set<String> Judge=new HashSet<>();
        for(String a:dictionary){
            Judge.add(a);
        }
        String[] words = sentence.split(" ");
        for(int i=0;i< words.length;i++){
            String word=words[i];
            for(int j=0;j<word.length();j++){
                if(Judge.contains(word.substring(0,j+1))){
                    word=word.substring(0,j+1);
                    words[i]=word;
                    break;
                }
            }
        }

        return String.join(" ",words);
    }
}
