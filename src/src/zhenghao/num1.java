package src.zhenghao;

/**
 * @author Etherstrings
 * @create 2022-10-22 11:27 zhenghao - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/22 - the current system date.  11:27 - the current system time.  2022 - the current year.  10 - the current month.  22 - the current day of the month.  11 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public boolean solve (String A, String B) {
        // write code here
        boolean flag=false;
        String left="";
        String right=A;
        if((right+left).equals(B)){
            flag=true;
            return flag;
        }

        for(int i=0;i<A.length();i++){
            char now=A.charAt(i);
            left+=now;
            if(i==A.length()-1){
                right="";
            }else {
                right=A.substring(i+1,A.length());
            }
            flag=(right+left).equals(B);
            if(flag==true){
                break;
            }
        }
        return flag;
    }
}
