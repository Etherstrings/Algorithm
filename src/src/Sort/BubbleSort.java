package src.Sort;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-08-30 22:01 Sort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BubbleSort - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/30 - the current system date.  22:01 - the current system time.  2022 - the current year.  08 - the current month.  30 - the current day of the month.  22 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] strs=in.nextLine().split(",");
            int[] num=new int[strs.length];
            for(int i=0;i<strs.length;i++){
                num[i]=Integer.parseInt(strs[i]);
            }
            sort(num);
            for(int i=0;i<num.length;i++){
                int a=num[i];
                if(i== num.length-1){
                    System.out.print(a);
                    break;
                }
                System.out.print(a+",");
            }
        }
    }
    public static void sort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
