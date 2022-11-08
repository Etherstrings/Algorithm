package StringExer;

/**
 * @author Etherstrings
 * @create 2022-11-01 14:06 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1662 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/1 - the current system date.  14:06 - the current system time.  2022 - the current year.  11 - the current month.  01 - the current day of the month.  14 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a="";
        String b="";
        for(String word:word1){
            a+=word;
        }
        for(String word:word2){
            b+=word;
        }
        return a.equals(b);
    }
}
