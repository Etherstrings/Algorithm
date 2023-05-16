package AcWing.Base.Tree_Grid.Bellman_ford;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-12 16:40 AcWing.Base.Tree_Grid.Bellman_ford - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A853 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/12 - the current system date.  16:40 - the current system time.  2023 - the current year.  05 - the current month.  12 - the current day of the month.  16 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A853 {
    static class Node
    {
        //a到b==c
        int a, b, c;
        public Node(int a,int b,int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    //Bellman_ford算法
    static int N = 510;
    static int M = 100010;
    static int n;//总点数
    static int m;//总边数
    static int k;//最多经过k条边
    static int[] dist = new int[N];//从1到点到n号点的距离
    static Node[] list = new Node[M];//结构体
    static int INF = 0x3f3f3f3f;
    static int[] back = new int[N];//备份dist数组

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        n=Integer.parseInt(line[0]);
        m=Integer.parseInt(line[1]);
        k=Integer.parseInt(line[2]);

        for(int i=0;i<m;i++){
            line=in.nextLine().split(" ");
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            int c=Integer.parseInt(line[2]);
            list[i]=new Node(a,b,c);
        }


        if(Bellman_ford()){
            System.out.println(dist[n]);
        }else {
            System.out.println("impossible");
        }
    }

    public static boolean Bellman_ford(){
        //确定距离矩阵的初始化
        Arrays.fill(dist,INF);

        //找1号点的距离，因此1号点的距离是确定的
        dist[1]=0;

        //多少条边的限制？
        for(int i=0;i<k;i++){
            //使用上一次迭代的1-n点的距离
            back=Arrays.copyOf(dist,n+1);

            //循环所有的边 更新距离
            for(int j=0;j<m;j++){
                Node now=list[j];
                int a=now.a;
                int b=now.b;
                int c=now.c;
                dist[b]=Math.min(dist[b],back[a]+c);
            }

        }
        if(dist[n]>INF/2){
            return false;
        }else {
            return true;
        }
    }
}
