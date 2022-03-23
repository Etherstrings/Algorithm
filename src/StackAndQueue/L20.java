package StackAndQueue;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-03-01 23:35 StackAndQueue - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L20 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/1 - the current system date.  23:35 - the current system time.  2022 - the current year.  03 - the current month.  01 - the current day of the month.  23 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L20 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //

    public boolean isValid(String s) {
        //思路
        //用栈来实现
        //先进 后出
        //后进 先出
        Stack<Character> judgement=new Stack<>();
        char[] chars = s.toCharArray();

        int z=0;
        int x=0;
        int c=0;

        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                judgement.push(')');
            }else if(chars[i]=='['){
                judgement.push(']');
            }else if(chars[i]=='{'){
                judgement.push('}');

            }else if(judgement.isEmpty()||judgement.peek()!=chars[i]){
                //如果栈顶元素不是当前遍历到的括号
                //那就无法一一消除
                return false;
            }else{
                judgement.pop();
            }
        }
        return judgement.isEmpty();

    }
}
