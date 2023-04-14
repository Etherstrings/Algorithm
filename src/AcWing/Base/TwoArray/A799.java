package AcWing.Base.TwoArray;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-27 18:07 AcWing.Base.TwoArray - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A799 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/27 - the current system date.  18:07 - the current system time.  2023 - the current year.  03 - the current month.  27 - the current day of the month.  18 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A799 {
    static int N=100010;
    static int[] A=new int[N];
    static int[] B=new int[N];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            A[i]=in.nextInt();
        }
        int left=1;
        int ans=-1;
        for(int right=1;right<=n;right++){
            B[A[right]]++;
            while(left<=right&&B[A[right]]>1){
                B[A[left]]--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        System.out.println(ans);
    }
}
