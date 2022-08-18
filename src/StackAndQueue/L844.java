package StackAndQueue;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-08-16 21:04 StackAndQueue - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L844 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/16 - the current system date.  21:04 - the current system time.  2022 - the current year.  08 - the current month.  16 - the current day of the month.  21 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str1=new Stack<>();
        Stack<Character> str2=new Stack<>();
        for(Character a:s.toCharArray()){
            if(str1.isEmpty()){
                if(a=='#'){
                    continue;
                }else {
                    str1.push(a);
                }
            }else {
                if(a=='#'){
                    str1.pop();
                }else {
                    str1.push(a);
                }
            }
        }

        for(Character a:t.toCharArray()){
            if(str2.isEmpty()){
                if(a=='#'){
                    continue;
                }else {
                    str2.push(a);
                }
            }else {
                if(a=='#'){
                    str2.pop();
                }else {
                    str2.push(a);
                }
            }
        }
        String strs="";
        String strt="";
        while(!str1.isEmpty()){
            strs+=str1.pop();
        }
        while(!str2.isEmpty()){
            strt+=str2.pop();
        }
        return strs.equals(strt);
    }
}
