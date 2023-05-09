package AcWing.Base.StackSort;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-28 16:41 AcWing.Base.StackSort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A838_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/28 - the current system date.  16:41 - the current system time.  2023 - the current year.  04 - the current month.  28 - the current day of the month.  16 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A838_1 {
    static int n, m;
    static int N = 100010;
    static int[] h = new int[N];
    static int size = 0;

    // 左右子树
    public static void down(int u) {
        //t表示的为
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        if (u != t) {
            swap(h, u, t);
            down(t);
        }
    }

    // 父节点
    public static void up(int u) {
        while(u/2 > 0 && h[u/2] > h[u]) {
            swap(h, u/2, u);
            u /= 2;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i ++) h[i] = sc.nextInt();
        size = n;

        for(int i = n / 2; i != 0; i --) down(i);

        while(m -- > 0){
            System.out.print(h[1] + " ");
            swap(h, 1, size);
            size --;
            down(1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
