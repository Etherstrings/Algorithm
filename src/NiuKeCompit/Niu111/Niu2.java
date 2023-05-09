package NiuKeCompit.Niu111;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-05-06 11:39 NiuKeCompit.Niu111 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Niu2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/6 - the current system date.  11:39 - the current system time.  2023 - the current year.  05 - the current month.  06 - the current day of the month.  11 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class Niu2 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return false;
        }
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        int times=0;
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1!=c2){
                times++;
            }
            if(map1.containsKey(c1)){
                map1.put(c1,map1.get(c1)+1);
            }else {
                map1.put(c1,1);
            }
            if(map2.containsKey(c2)){
                map2.put(c1,map2.get(c2)+1);
            }else {
                map2.put(c2,1);
            }
        }
        boolean flag=true;
        for(char key1: map1.keySet()){
            if(!map2.containsKey(key1)){
                flag=false;
                break;
            }
            if(map2.get(key1)!=map1.get(key1)){
                flag=false;
                break;
            }
        }
        if(times!=2){
            flag=false;
        }
        return flag;
    }
}
