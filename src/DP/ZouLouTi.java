package DP;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-04 13:35 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  ZouLouTi - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/4 - the current system date.  13:35 - the current system time.  2022 - the current year.  09 - the current month.  04 - the current day of the month.  13 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class ZouLouTi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(Louti(m));
    }
    static int Louti(int m){
        if(m<=0){
            return 0;
        }
        int[] dp=new int[m+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[m];
    }
}
