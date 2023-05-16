package AcWing.Base.Tree_Grid.Grid_TuoPU;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-10 12:31 AcWing.Base.Tree_Grid.Grid_TuoPU - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A848_JAPI_II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/10 - the current system date.  12:31 - the current system time.  2023 - the current year.  05 - the current month.  10 - the current day of the month.  12 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A848_JAPI_II {
    //这里是采用了一个存储数组来表示第二个链表的作用
    static int N = 100010;
    static int[] h = new int[N];       //以第一个节点的编号为索引，存储所有单链表的头节点
    static int[] e = new int[N];       //以当前要操作的节点为索引，存储第二个节点的编号
    static int[] ne = new int[N];      //以当前操作的节点为索引，存储下一个节点
    static int[] d = new int[N];       //存储i号节点的入度
    static int[] top = new int[N];
    static Queue<Integer> q = new LinkedList<>();
    static int idx,n,cnt = 1;         //cnt指的是top中有多少元素

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int m = in.nextInt();

        for(int i = 0; i < N; i ++) h[i] = -1;

        for(int i = 0; i < m; i ++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a,b);
            d[b]++;                    //入度+1
        }

        if(topsort())
        {
            for(int i = 1; i <= n; i ++) System.out.print(top[i] + " ");
        }
        else System.out.print("-1");
    }

    private static void add(int a ,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean topsort()
    {
        for(int i = 1; i <= n; i ++)             //因为是从1开始编号的，所以从1开始遍历
        {
            if(d[i] == 0) q.offer(i);            //遍历每个节点，入度为0就入栈
        }

        while(q.size() != 0)
        {
            int t = q.poll();
            top[cnt] = t;
            cnt++;

            for(int i =h[t]; i != -1; i = ne[i])  //遍历链表，删除1的所有出度
            {
                int j = e[i];                     //j找到第一个节点指向的点b
                if(--d[j] == 0) q.offer(j);       //删除边
            }
        }

        return cnt >= n;                          //注意这里一定是>=,因为cnt = 3以后会++等于4
    }
}
