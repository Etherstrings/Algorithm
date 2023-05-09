package leetcode.week344;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-05-07 12:10 leetcode.week344 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  FrequencyTracker - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/7 - the current system date.  12:10 - the current system time.  2023 - the current year.  05 - the current month.  07 - the current day of the month.  12 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class FrequencyTracker {
    public Map<Integer,Integer> tarcker;
    public FrequencyTracker() {
        tarcker=new HashMap<>();
    }

    public void add(int number) {
        if(tarcker.containsKey(number)){
            tarcker.put(number,tarcker.get(number)+1);
        }else {
            tarcker.put(number,1);
        }
    }

    public void deleteOne(int number) {
        if(tarcker.containsKey(number)){
            if(tarcker.get(number)==1){
                tarcker.remove(number);
            }else {
                tarcker.put(number,tarcker.get(number)-1);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        boolean flag=false;
        for(int num:tarcker.keySet()){
            if(tarcker.get(num)==frequency){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
