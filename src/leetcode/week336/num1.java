package leetcode.week336;

/**
 * @author Etherstrings
 * @create 2023-03-12 10:28 leetcode.week336 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  10:28 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  10 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int vowelStrings(String[] words, int left, int right) {
        String Yuan="aeiou";
        int ans=0;
        for(int i=left;i<=right;i++){
            if(Yuan.contains(words[i].charAt(0)+"")&&Yuan.contains(words[i].charAt(words[i].length()-1)+"")){
                ans++;
            }
        }
        return ans;
    }
}
