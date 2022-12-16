package src.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-30 22:14 Sort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SelectSort - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/30 - the current system date.  22:14 - the current system time.  2022 - the current year.  08 - the current month.  30 - the current day of the month.  22 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class SelectSort {
    public static void sort(int[] arr){
        List<Integer> Sorted=new ArrayList<>();
        List<Integer> Unsorted= new ArrayList<>();
        for(int a:arr){
            Unsorted.add(a);
        }
        while (Unsorted.size()!=0){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<Unsorted.size();i++){
                min=Math.max(min,Unsorted.get(i));
            }
            for(int i=0;i<Unsorted.size();i++){
                if(min== Unsorted.get(i)){
                    index=i;
                    break;
                }
            }
            Sorted.add(min);
            Unsorted.remove(index);
        }
        int index=0;
        for(int a:Sorted){
            arr[index]=a;
            index++;
        }
    }
}
