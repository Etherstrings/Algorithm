package AcWing.Base.Hash;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-30 16:31 AcWing.Base.Hash - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A840_I - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/30 - the current system date.  16:31 - the current system time.  2023 - the current year.  04 - the current month.  30 - the current day of the month.  16 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A840_I {
    private static int N = 200003;
    private static Integer[] a = new Integer[N];

    public static int find(int x){
        int k = (x % N + N) % N;
        //如果当前插槽不为空
        //并且当前插槽的值不是x
        while(a[k]!=null&&a[k]!=x){
            k++;
            if(k==N){
                k=0;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        Arrays.fill(a,null);
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while(m-- > 0){
            String opt = scanner.next();
            int x = scanner.nextInt();
            if("I".equals(opt)){
                a[find(x)] = x;
            }else{
                //这是比较的是a[find(x)]
                System.out.println(a[find(x)] == null ? "No" : "Yes");
            }
        }
    }
}
