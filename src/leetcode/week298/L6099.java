package leetcode.week298;

/**
 * @author Etherstrings
 * @create 2022-06-19 11:20 leetcode.week298 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6099 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  11:20 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  11 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L6099 {
    //取最长的子序列

    //子序列转换后小于等于正整数k


    //思路 取所有小于k的子序列

        //判断谁最长


        //思路错了

        //这里写的是子序列

        //不是连续子序列

        //回溯

    public int longestSubsequence(String s, int k) {
        return 1;
    }

    void BackTarcking(int index,String s,int k){
        if(index==s.length()-1){

        }
    }

    boolean isbig(String s,int k){
        String temp="";
        if(s.equals(temp)){
            //此时s视为0
            if(0<=k){
                return true;
            }else {
                return false;
            }
        }

        if(Integer.parseInt(s)<=k){
            return true;
        }
        return false;
    }
}
