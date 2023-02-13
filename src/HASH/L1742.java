package HASH;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-11-26 14:03 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1742 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/26 - the current system date.  14:03 - the current system time.  2022 - the current year.  11 - the current month.  26 - the current day of the month.  14 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1742 {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer> box=new HashMap<>();
        int size=0;
        for(int i=lowLimit;i<=highLimit;i++){
            String now=""+i;
            int index=0;
            for(char c:now.toCharArray()){
                index+=Integer.parseInt(c+"");
            }
            if(box.containsKey(index)){
                box.put(index,box.get(index)+1);
                size=Math.max(size,box.get(index));
            }else {
                box.put(index,1);
                size=Math.max(size,1);
            }
        }
        return size;
    }
}
