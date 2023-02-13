package src.Sort;

/**
 * @author Etherstrings
 * @create 2022-08-30 21:12 Sort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  InsertSort - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/30 - the current system date.  21:12 - the current system time.  2022 - the current year.  08 - the current month.  30 - the current day of the month.  21 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class InsertSort {
    //插入排序
    //将待插元素
    //与已排序子数列从后往前进行比较
    public static void sort(int[] arr) {
        if(arr.length>=2){
            for(int i=1;i<arr.length;i++){
                int temp=arr[i];

                //已经排序的边界
                int j=i-1;

                while (j>=0&&arr[j]>temp){
                    arr[j+1]=arr[j];
                    j--;
                }
                arr[j+1]=temp;
            }
        }
    }
}
