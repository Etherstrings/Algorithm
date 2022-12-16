package src.StringExer;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-11-08 18:11 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1678 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/8 - the current system date.  18:11 - the current system time.  2022 - the current year.  11 - the current month.  08 - the current day of the month.  18 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1678 {
    public static String interpret(String command) {
        String ans="";
        if(command==null){
            return ans;
        }
        if(command.length()==0){
            return ans;
        }
        Stack<Character> jud=new Stack<>();
        for(char a:command.toCharArray()){
            if(a=='G'){
                ans+=a;
                continue;
            }
            if(a==')'){
                if(jud.peek()=='('){
                    ans+='o';
                    jud.pop();
                    continue;
                }else {
                    ans+="al";
                    //l
                    jud.pop();
                    //a
                    jud.pop();
                    //(
                    jud.pop();
                    continue;
                }
            }
            jud.add(a);
        }
        return ans;
    }
}
