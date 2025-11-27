package leetcode.week347;

/**
 * @author Etherstrings
 * @create 2023-05-28 10:34 leetcode.week347 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/28 - the current system date.  10:34 - the current system time.  2023 - the current year.  05 - the current month.  28 - the current day of the month.  10 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public String removeTrailingZeros(String num) {
        StringBuilder ans=new StringBuilder("");
        int index=-1;
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i)=='0'){
                index=i;
            }else {
                break;
            }
        }
        if(index==-1){
            return num;
        }
        for(int i=0;i<index;i++){
            ans.append(num.charAt(i));
        }
        return ans.toString();
    }
}
