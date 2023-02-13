package DP;

/**
 * @author Etherstrings
 * @create 2022-09-12 16:52 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L5_LongestString - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/12 - the current system date.  16:52 - the current system time.  2022 - the current year.  09 - the current month.  12 - the current day of the month.  16 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L5_LongestString {
    //动态规划
    //最长回文子串
    public String longestPalindrome(String s) {
        if(s.length()==0||s.length()==1){
            return s;
        }
        int len=0;
        int index=0;
        //i-j是不是回文子串？
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        String ans="";
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                //三种情况合并
                //j-i==0 当前是一个字符 肯定是回文
                //j-i==1 aa 当前也是回文子串
                //j-i>1 abcacba 看i+1和j-1是不是相同
                if(chars[i]==chars[j]&&(j-i<=1||palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                }

                //如果当前是最大值
                if(palindrome[i][j]==true&&j-i+1>len){
                    len=j-i+1;
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}
