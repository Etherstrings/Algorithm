package src;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-28 19:37 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1331 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  19:37 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  19 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int i=0;i<clone.length;i++){
            if(Judge.containsKey(clone[i])){
                continue;
            }else {
                Judge.put(clone[i],Judge.size()+1);
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=Judge.get(arr[i]);
        }
        return arr;
    }
}
