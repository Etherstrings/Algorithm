package Stack;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-08-31 21:05 Stack - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L946 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/31 - the current system date.  21:05 - the current system time.  2022 - the current year.  08 - the current month.  31 - the current day of the month.  21 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index=0;
        Stack<Integer> Judge=new Stack<>();
        for(int i=0;i<pushed.length;i++){
            Judge.push(pushed[i]);
            while(!Judge.isEmpty()&&Judge.peek()==popped[index]){
                Judge.pop();
                index++;
            }
        }
        return Judge.isEmpty();
    }
}
