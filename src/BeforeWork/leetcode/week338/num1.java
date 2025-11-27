package leetcode.week338;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-26 10:30 leetcode.week338 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/26 - the current system date.  10:30 - the current system time.  2023 - the current year.  03 - the current month.  26 - the current day of the month.  10 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<numOnes;i++){
            temp.add(1);
        }
        for(int i=0;i<numZeros;i++){
            temp.add(0);
        }
        for(int i=0;i<numNegOnes;i++){
            temp.add(-1);
        }
        int ans=0;
        for(int i=0;i<k;i++){
            ans+=temp.get(i);
        }
        return ans;
    }
}
