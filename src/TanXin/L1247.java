package TanXin;

/**
 * @author Etherstrings
 * @create 2023-02-25 1:05 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1247 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  1:05 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  01 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1247 {
    public int minimumSwap(String s1, String s2) {
        int howmany=0;
        int x=0;
        int y=0;
        for(int i=0;i<s1.length();i++){
            char a1=s1.charAt(i);
            char a2=s2.charAt(i);
            if(a2!=a1){
                howmany++;
                if(a1=='x'){
                    x++;
                }else {
                    y++;
                }
            }
        }
        if(howmany%2==1){
            return -1;
        }
        int ans=0;
        if(x%2==0){
            ans=howmany/2;
        }else {
            ans=howmany/2+1;
        }
        return ans;
    }
}
