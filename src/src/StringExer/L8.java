package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-11-26 14:16 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L8 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/26 - the current system date.  14:16 - the current system time.  2022 - the current year.  11 - the current month.  26 - the current day of the month.  14 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L8 {
    public static int myAtoi(String s) {
        String str="";
        //前面的所有空格滤除
        //第一个"-"保留
        //之后再遇到任何不是数字的 停止
        boolean hasvi=false;
        String temp="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }else {
                //此时i所在字符不为0
                temp=s.substring(i,s.length());
                break;
            }
        }
        if(temp.equals("")){
            return 0;
        }
        s=temp;
        for(int i=0;i<s.length();i++){
            char now=s.charAt(i);
            if(hasvi==false){
                //此时还没有有效数字
                if(now=='-'||Character.isDigit(now)||now=='+'){
                    str+=now;
                    //拼上了第一个有效数字
                    hasvi=true;
                }else {
                    break;
                }
            }else {
                //此时已经在拼有效数字了
                if(Character.isDigit(now)){
                    str+=now;
                }else {
                    break;
                }
            }
        }
        if(str.equals("")||str.equals("-")||str.equals("+")){
            return 0;
        }
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return str.charAt(0)=='-'?Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

    }
}
