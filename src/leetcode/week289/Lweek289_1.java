package leetcode.week289;

/**
 * @author Etherstrings
 * @create 2022-04-17 10:40 leetcode.week289 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Lweek289_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/17 - the current system date.  10:40 - the current system time.  2022 - the current year.  04 - the current month.  17 - the current day of the month.  10 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class Lweek289_1 {

    public String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        int size=s.length();
        String news="";
        while(size>k){
            String temp=s.substring(0,k);
            s=s.substring(k-1);
            news+=sumk(temp);
            size=s.length();
        }
        news+=sumk(s);

        /**
         *
         */

        return "";
    }


    //将传入的字符串转为新的字符串
    public String sumk(String s){
        char[] chars = s.toCharArray();
        int sum=0;
        for(int i=0;i<chars.length;i++){
            int temp=chars[i]-'0';
            sum+=temp;
        }
        return String.valueOf(sum);
    }

}
