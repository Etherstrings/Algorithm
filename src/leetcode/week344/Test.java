package leetcode.week344;

/**
 * @author Etherstrings
 * @create 2023-05-07 12:30 leetcode.week344 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Test - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/7 - the current system date.  12:30 - the current system time.  2023 - the current year.  05 - the current month.  07 - the current day of the month.  12 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class Test {
    public static void main(String[] args) {
        FrequencyTracker1 fre=new FrequencyTracker1();
        fre.add(5);
        fre.add(5);
        System.out.println(fre.hasFrequency(1));
        System.out.println(fre.hasFrequency(2));
    }
}
