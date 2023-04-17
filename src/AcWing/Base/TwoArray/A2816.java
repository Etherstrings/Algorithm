package AcWing.Base.TwoArray;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-28 1:07 AcWing.Base.TwoArray - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A2816 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/28 - the current system date.  1:07 - the current system time.  2023 - the current year.  03 - the current month.  28 - the current day of the month.  01 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A2816 {
    public static int N=100010;
    public static int[] A=new int[N];
    public static int[] B=new int[N];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        if(n>m){
            System.out.println("No");
        }else {
            for(int i=1;i<=n;i++){
                A[i]=in.nextInt();
            }
            for(int i=1;i<=m;i++){
                B[i]=in.nextInt();
            }
            int slow=1;
            for(int fast=1;fast<=m;fast++){
                if(slow==n+1){
                    break;
                }
                if(B[fast]==A[slow]){
                    slow++;
                }
            }
            if(slow!=n+1){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}
