package AcWing.Base.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-16 23:07 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A860_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  23:07 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  23 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A860_ACM {
    // 无向图,邻接表指针2*(n-1)故令M为2N
    public static int N=100010,M=N*2;

    // h[]存储邻接表各个头结点
    public static int[] h=new int[N];
    //index-Value  这个index对应的值
    public static int[] e=new int[M];
    //index.next  这个index对应的下个节点
    public static int[] ne=new int[M];
    //这个为当前链表可用的插槽指向哪里
    public static int idx;
    /**
     * 头插法
     * e记录当前点的值,ne下一点的地址,h记录指向的第一个点的地址,idx:当前用到了哪个结点(的下标)
     * @param a
     * @param b
     */
    public static void add(int a,int b){
        e[idx]=b;
        ne[idx]=h[a];
        h[a]=idx;
        idx++;
    }
    public static int[] Color=new int[N];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Arrays.fill(h,-1);
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            add(a,b);
            add(b,a);
        }
        boolean flag=true;
        for(int i=1;i<=n;i++){
            //这个判断有点意思
            //为什么要判断这个点是不是被染色过？
            //因为：一旦被染色了，那说明这个点是子集
            //子集的结果存在于父集中
            //不可再看子集--因为重复判断
            if(Color[i]==0){
                if(bfs(i,1)==false){
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean bfs(int start,int scolor){
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{start,scolor});
        boolean flag=true;
        while(!que.isEmpty()){
            int[] now=que.poll();
            int index=now[0];
            int color=now[1];
            for(int i=h[index];i!=-1;i=ne[i]){
                int nindex=e[i];
                if(Color[nindex]==0){
                    Color[nindex]=3-color;
                    que.offer(new int[]{nindex,Color[nindex]});
                }else {
                    if(Color[nindex]==color){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
