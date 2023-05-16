package AcWing.Base.Tree_Grid.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-11 11:38 AcWing.Base.Tree_Grid.Dijkstra - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A850_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/11 - the current system date.  11:38 - the current system time.  2023 - the current year.  05 - the current month.  11 - the current day of the month.  11 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A850_ACM {
    //简化迪杰特斯拉求最短路的ACM模式写法
    //即 存邻接表用数组模拟
    //   优先队列采用API
    static int n = 0, m = 0, N = 1000010;
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx = 1;

    public static int[] dist;
    public static boolean[] state;
    static PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{return a[1] - b[1];});//堆
    public static void main(String[] args) {
        dist=new int[N];
        state=new boolean[N];
        Arrays.fill(h,-1);
        Arrays.fill(dist,Integer.MAX_VALUE);
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            add(a,b,c);
        }
        System.out.println(Dijkstra());
    }

    public static int Dijkstra(){//类似广搜的过程
        dist[1] = 0;//初始化第一个点到自身的距离
        q.offer(new int[]{1, 0});
        while(q.size() != 0){
            int[] a = q.poll();
            int t = a[0], distance = a[1];
            if(state[t])continue;
            state[t] = true;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    q.offer(new int[]{j, dist[j]});
                }
            }
        }
        if(dist[n] != 0x3f3f3f3f)return dist[n];
        return -1;
    }

    //模拟数组版的初始构建
    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c;ne[idx] = h[a]; h[a] = idx++;
    }
}
