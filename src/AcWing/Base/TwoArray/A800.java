package AcWing.Base.TwoArray;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-28 0:55 AcWing.Base.TwoArray - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A800 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/28 - the current system date.  0:55 - the current system time.  2023 - the current year.  03 - the current month.  28 - the current day of the month.  00 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A800 {
    public static int N=100010;
    public static long[] A=new long[N];
    public static long[] B=new long[N];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int target=in.nextInt();
        for(int i=1;i<=n;i++){
            A[i]=in.nextLong();
        }
        for(int i=1;i<=m;i++){
            B[i]=in.nextLong();
        }
        int left=1;
        int right=m;
        while(left<=n&&right>=1){
            if(A[left]+B[right]==target){
                System.out.println((left-1)+" "+(right-1));
                break;
            }else if(A[left]+B[right]>target){
                right--;
            }else {
                left++;
            }
        }
    }
}
