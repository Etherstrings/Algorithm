import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2022-08-24 12:30 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1460 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  12:30 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  12 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> targetmap=new HashMap<>();
        HashSet<Integer> tset=new HashSet<>();
        HashMap<Integer,Integer> arrmap=new HashMap<>();
        HashSet<Integer> aset=new HashSet<>();

        for(int a:target){
            tset.add(a);
            if(targetmap.containsKey(a)){
                targetmap.put(a,targetmap.get(a)+1);
            }else {
                targetmap.put(a,1);
            }
        }

        for(int a:arr){
            aset.add(a);
            if(arrmap.containsKey(a)){
                arrmap.put(a,arrmap.get(a)+1);
            }else{
                arrmap.put(a,1);
            }
        }

        for(int a:aset){
            if(!tset.contains(a)){
                return false;
            }
            if(arrmap.get(a)!=targetmap.get(a)){
                return false;
            }
        }
        return true;
    }
}
