package TwoPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-01-13 22:38 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L02 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/13 - the current system date.  22:38 - the current system time.  2022 - the current year.  01 - the current month.  13 - the current day of the month.  22 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L02 {
    /**
     *  3. 无重复字符的最长子串
     *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *   输    入: s = ""
     *  输    出: 0
     *
     */


        public int lengthOfLongestSubstring(String s) {
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
