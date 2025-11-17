package TanXin;

/**
 * @author Etherstrings
 * @create 2023-03-01 1:25 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L402 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/1 - the current system date.  1:25 - the current system time.  2023 - the current year.  03 - the current month.  01 - the current day of the month.  01 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L402 {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        while(k>0){
            //去掉前边的0
            num=Integer.parseInt(num)+"";
            if(num.equals("0")){
                break;
            }
            if(num.length()==k){
                return "0";
            }
            for(int i=0;i<num.length();i++){
                if(i==num.length()-1){
                    num=num.substring(1,num.length());
                    break;
                }
                if(num.charAt(i)>num.charAt(i+1)){
                    //删当前这个数
                    String left=num.substring(0,i);
                    String right=num.substring(i+1,num.length());
                    num=left+right;
                    break;
                }
            }
            k--;
        }
        return num;
    }
}
