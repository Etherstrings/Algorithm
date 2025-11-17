package AcWing.Base.DFS;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-02 13:39 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A842_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/2 - the current system date.  13:39 - the current system time.  2023 - the current year.  05 - the current month.  02 - the current day of the month.  13 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A842_I {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        boolean[] used=new boolean[n+1];
        dfs(n,used,1);
    }
    public static int[] Bucket=new int[10];

    public static void dfs(int n,boolean[] used,int which){
        if(which==n+1){
            for(int i=1;i<=n;i++){
                if(i==n){
                    System.out.println(Bucket[i]);
                    continue;
                }
                System.out.print(Bucket[i]+" ");
            }
        }
        for(int i=1;i<=n;i++){
            if(used[i]==false){
                //可以用
                Bucket[which]=i;
                used[i]=true;
                dfs(n,used,which+1);
                used[i]=false;
                Bucket[which]=0;
            }
        }
    }
}
