package TwoPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-11-10 12:40 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L03_2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/10 - the current system date.  12:40 - the current system time.  2022 - the current year.  11 - the current month.  10 - the current day of the month.  12 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L03_2 {
    public int getMaxLength (int[] arr) {
        // write code here
        String s="";
        for(int a:arr){
            s+=a;
        }
        return lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> Judgement = new HashMap<>();
        char[] chars = s.toCharArray();

        if (s.equals("")) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int max = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (Judgement.containsKey(chars[right])) {
                left = Math.max(left,Judgement.get(chars[right])+1);


            }
            Judgement.put(chars[right], right);
            max=Math.max(max,right-left+1);


        }
        return max;
    }
}
