package CSBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-23 0:06 CSBasic - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L89 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/23 - the current system date.  0:06 - the current system time.  2023 - the current year.  02 - the current month.  23 - the current day of the month.  00 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L89 {
    public List<Integer> grayCode(int n) {
        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        for (int i = 0; i < n; i++)
            for (int j = grayCode.size() - 1; j >= 0; j--)
                grayCode.add(grayCode.get(j) + (1 << i));
        return grayCode;
    }
}
