package StringExer;

/**
 * @author Etherstrings
 * @create 2023-03-06 23:53 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1653 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/6 - the current system date.  23:53 - the current system time.  2023 - the current year.  03 - the current month.  06 - the current day of the month.  23 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1653 {
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;

        //aaabbb
        //左边删b 右边删a
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                //在这里有a
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }

}
