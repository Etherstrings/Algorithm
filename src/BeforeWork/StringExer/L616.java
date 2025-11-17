package StringExer;

/**
 * @author Etherstrings
 * @create 2023-03-18 13:43 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L616 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  13:43 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  13 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L616 {
    public boolean checkPalindromeFormation(String a, String b) {
        boolean flag=false;
        if(a.equals(b)){
            return true;
        }
        if(a.length()==1){
            return true;
        }
        for(int i=1;i<a.length();i++){
            String aleft=a.substring(0,i);
            String aright=a.substring(i,a.length());

            String bleft=b.substring(0,i);
            String bright=b.substring(i,a.length());

            StringBuilder sb1=new StringBuilder(bright);
            StringBuilder sb2=new StringBuilder(bleft);
            if(aleft.equals(sb1.reverse().toString())||aright.equals(sb2.reverse().toString())){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
