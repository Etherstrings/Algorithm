package TwoTo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-18 0:56 TwoTo2 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1237 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/18 - the current system date.  0:56 - the current system time.  2023 - the current year.  02 - the current month.  18 - the current day of the month.  00 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1237 {
    abstract class CustomFunction {
 //Returns f(x, y) for any given positive integers x and y.
 //Note that f(x, y) is increasing with respect to both x and y.
// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public abstract int f(int x, int y);
 }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1;x <= z;x++) {
            int l = 1;
            int r = z + 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (customfunction.f(x,m) == z) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(m);
                    res.add(temp);
                    break;
                } else if (customfunction.f(x,m) < z) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return res;
    }
}
