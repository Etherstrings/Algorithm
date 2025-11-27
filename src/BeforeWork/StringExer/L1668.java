package StringExer;

/**
 * @author Etherstrings
 * @create 2022-11-05 17:22 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1668 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/5 - the current system date.  17:22 - the current system time.  2022 - the current year.  11 - the current month.  05 - the current day of the month.  17 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1668 {
    public int maxRepeating(String sequence, String word) {
        int time=0;
        if(sequence.indexOf(word)==-1){
            return time;
        }
        while(sequence.indexOf(word)!=-1){
            time++;
            int start=sequence.indexOf(word);
            int end=start+word.length();
            sequence=sequence.substring(end,sequence.length());
        }
        return time;
    }
}
