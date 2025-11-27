package AcWing.Base.PreSum;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-21 21:06 AcWing.Base.PreSum - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A795 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/21 - the current system date.  21:06 - the current system time.  2023 - the current year.  03 - the current month.  21 - the current day of the month.  21 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A795 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int[] PreS=new int[n+1];
        for(int i=0;i<PreS.length;i++){
            if(i==0){
                PreS[i]=0;
                continue;
            }
            PreS[i]=PreS[i-1]+nums[i-1];
        }
        while(m--!=0){
            int l=in.nextInt();
            int r=in.nextInt();
            System.out.println(PreS[r]-PreS[l-1]);
        }
    }
}
