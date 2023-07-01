package StringExer;

/**
 * @author Etherstrings
 * @create 2023-06-30 0:04 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2490 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/30 - the current system date.  0:04 - the current system time.  2023 - the current year.  06 - the current month.  30 - the current day of the month.  00 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L2490 {
    //2490. 回环句
    //句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
    //
    //例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
    //单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
    //
    //如果句子满足下述全部条件，则认为它是一个 回环句 ：
    //
    //单词的最后一个字符和下一个单词的第一个字符相等。
    //最后一个单词的最后一个字符和第一个单词的第一个字符相等。
    //例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
    //
    //给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
    //
    //
    public static void main(String[] args) {
        String sentesce="leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentesce));
    }
    public static boolean isCircularSentence(String sentence) {
        boolean flag=true;
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length-1;i++){
            if(words[i].charAt(words[i].length()-1)!=words[i+1].charAt(0)){
                flag=false;
                break;
            }
        }
        if(words[0].charAt(0)!=words[words.length-1].charAt(words[words.length-1].length()-1)){
            flag=false;
        }
        return flag;
    }
}
