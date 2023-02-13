package HASH;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-11-12 12:07 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BM51 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/12 - the current system date.  12:07 - the current system time.  2022 - the current year.  11 - the current month.  12 - the current day of the month.  12 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class BM51 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:array){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        int ans=-1;
        for(int a:array){
            if(map.get(a)>array.length/2){
                ans=a;
                break;
            }
        }
        return ans;
    }
}
