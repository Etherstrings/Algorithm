package AcWing.Base.ReduceSort;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-23 17:21 AcWing.Base.ReduceSort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A797 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  17:21 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  17 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A797 {
    static int N = 100010;
    static int[] A=new int[N];
    static int[] B=new int[N];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();

        for(int i=1;i<=n;i++){
            A[i]=in.nextInt();
        }
        //构造B数组
        for(int i=1;i<=n;i++){
            insert(i,i,A[i]);
        }
        while(m-->0){
            int l=in.nextInt();
            int r=in.nextInt();
            int c=in.nextInt();
            insert(l,r,c);
        }
        //构造执行后的前缀和
        for(int i=1;i<=n;i++){
            B[i]+=B[i-1];
        }
        for(int i = 1; i <= n; i ++){
            System.out.println(B[i]);
        }
    }

    public static void insert(int l,int r,int c){
        B[l]+=c;
        B[r+1]-=c;
    }
}
