package StackAndQueue;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-03-02 23:48 StackAndQueue - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1047 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/2 - the current system date.  23:48 - the current system time.  2022 - the current year.  03 - the current month.  02 - the current day of the month.  23 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1047 {
    //1047. 删除字符串中的所有相邻重复项
    //给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
    //
    //在 S 上反复执行重复项删除操作，直到无法继续删除。
    //
    //在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charjudgement = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(charjudgement.isEmpty()||charjudgement.peek()!=chars[i]){
                charjudgement.push(chars[i]);
            }else {
                charjudgement.pop();
            }
        }
        StringBuffer answer=new StringBuffer();
        while(charjudgement.isEmpty()==false){
            answer.append(charjudgement.pop());
        }

        return answer.reverse().toString();
    }
}
