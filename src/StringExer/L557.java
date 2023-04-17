package StringExer;

/**
 * @author Etherstrings
 * @create 2023-02-23 21:04 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L557 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/23 - the current system date.  21:04 - the current system time.  2023 - the current year.  02 - the current month.  23 - the current day of the month.  21 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L557 {
    //557. 反转字符串中的单词 III
    //给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "Let's take LeetCode contest"
    //输出："s'teL ekat edoCteeL tsetnoc"
    //示例 2:
    //
    //输入： s = "God Ding"
    //输出："doG gniD"
    public String reverseWords(String s) {
        String[] ss=s.split(" ");
        StringBuffer sb=new StringBuffer();

        for(String n:ss){
            StringBuffer sd=new StringBuffer();
            sb.append(sd.append(n).reverse()).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
