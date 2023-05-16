package AcWing.Base.Tree_Grid.SPFA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-13 10:33 AcWing.Base.Tree_Grid.SPFA - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A851_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/13 - the current system date.  10:33 - the current system time.  2023 - the current year.  05 - the current month.  13 - the current day of the month.  10 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A851_ACM {
    //1.存为邻接表-数组+链表实现
    //2.queue用acm模式实现
    public static int N=100010;

    //距离数组
    public static int[] dist=new int[N];

    //判断是否更新数组
    public static boolean[] used=new boolean[N];

    //邻接表
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx = 1;
    //模拟数组版的初始构建
    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c;ne[idx] = h[a]; h[a] = idx++;
    }

    public static void main(String[] args) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        //初始化邻接矩阵
        Arrays.fill(h,-1);
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            add(a,b,c);
        }
        if(spfa(n)){
            System.out.println(dist[n]);
        }else {
            System.out.println("impossible");
        }

    }

    public static boolean spfa(int n){
        Queue<Integer> que=new LinkedList<>();
        dist[1]=0;
        used[1]=true;
        que.offer(1);

        while(!que.isEmpty()){
            int now=que.poll();
            used[now]=false;
            for(int i=h[now];i!=-1;i=ne[i]){
                int index=e[i];
                if(dist[index]>dist[now]+w[i]){
                    dist[index]=dist[now]+w[i];
                    if(used[index]==false){
                        used[index]=true;
                        que.offer(index);
                    }
                }
            }
        }
        return !(dist[n]==Integer.MAX_VALUE);
    }

}
