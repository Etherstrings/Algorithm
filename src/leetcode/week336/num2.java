package leetcode.week336;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-12 10:34 leetcode.week336 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  10:34 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  10 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int maxScore(int[] nums) {
        List<Integer> numss=new ArrayList<>();
        for(int num:nums){
            numss.add(num);
        }
        Collections.sort(numss);
        Collections.reverse(numss);
        long[] pre=new long[nums.length];
        int ans=0;
        for(int i=0;i<pre.length;i++){
            if(i==0){
                pre[i]=numss.get(i);
                if(pre[i]>0){
                    ans++;
                }
                continue;
            }
            pre[i]=pre[i-1]+numss.get(i);
            if(pre[i]>0){
                ans++;
            }
        }

        return ans;
    }
}
